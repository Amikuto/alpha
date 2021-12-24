package per.ami.alpha.client;

import lombok.SneakyThrows;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StreamUtils;
import per.ami.alpha.pojo.dto.Currency;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9091)
class CurrencyServiceClientTest {

    @Autowired
    private CurrencyServiceClient client;

    private final Resource currencies = new ClassPathResource("stubs/currencies.json");

    @Test
    void getLastCurrencies() {
        stubFor(get(urlPathEqualTo("/latest.json"))
                .withQueryParam("app_id", matching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(asJson(currencies))));

        Currency currency = client.getLastCurrencies();
        assertThat(currency.getBase()).isEqualTo("USD");
        assertThat(currency.getRates()).isNotNull();
        assertThat(currency.getRates().get("AED")).isCloseTo(400.67294f, Percentage.withPercentage(10));
    }

    @Test
    void getYesterdayCurrencies() {
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

        stubFor(get(urlPathEqualTo("/historical/" + yesterday.format(formatter) + ".json"))
                .withQueryParam("app_id", matching(".*"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(asJson(currencies))));


        Currency currency = client.getYesterdayCurrencies(formatter.format(yesterday));
        assertThat(currency.getBase()).isEqualTo("USD");
        assertThat(currency.getRates()).isNotNull();
        assertThat(currency.getRates().get("AED")).isCloseTo(400.67294f, Percentage.withPercentage(10));
    }

    @SneakyThrows
    private String asJson(Resource resource) {
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }
}