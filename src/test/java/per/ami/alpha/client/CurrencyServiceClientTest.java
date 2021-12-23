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
import org.springframework.util.StreamUtils;
import per.ami.alpha.pojo.dto.Currency;
import wiremock.org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9091)
class CurrencyServiceClientTest {

    @Autowired
    private CurrencyServiceClient client;

    private final Resource currencies = new ClassPathResource("stubs/currencies.json");

    @Test
    void getLastCurrencies() {

        stubFor(get(urlEqualTo("/latest.json?app_id=${app.feign.config.token.currency}"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(asJson(currencies))));

        Currency currency = client.getLastCurrencies();
        assertThat(currency.getBase()).isEqualTo("USD");
        assertThat(currency.getRates()).isNotNull();
        assertThat(currency.getRates().get("AED")).isCloseTo(3.67294f, Percentage.withPercentage(10));
    }

    @SneakyThrows
    private String asJson(Resource resource) {
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }

    @Test
    void getYesterdayCurrencies() {
    }
}