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
import per.ami.alpha.pojo.dto.Gif;

import java.nio.charset.Charset;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9091)
class GifServiceClientTest {

    @Autowired
    private GifServiceClient client;

    private final Resource gif = new ClassPathResource("stubs/gif.json");

    @Test
    void getGif() {
        String tag = "rich";
        stubFor(get(urlPathEqualTo("/random"))
                .withQueryParam("api_key", matching(".*"))
                .withQueryParam("tag", matching("(rich|broke)"))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(asJson(gif))));

        Gif gif = client.getGif(tag);
        assertThat(gif.getData().getType()).isEqualTo("gif");
        assertThat(gif.getData().getId()).isEqualTo("2yA8unAL4YglXE0QEG");
        assertThat(gif.getData().getImages().getOriginal().get("url")).isEqualTo("https://media0.giphy.com/media/2yA8unAL4YglXE0QEG/giphy.gif?cid=34f66c65899732597b63fa0bee5791f2dd9fd325425e403b&rid=giphy.gif&ct=g");
    }

    @SneakyThrows
    private String asJson(Resource resource) {
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }
}