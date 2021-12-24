package per.ami.alpha.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import per.ami.alpha.client.CurrencyServiceClient;
import per.ami.alpha.client.GifServiceClient;
import per.ami.alpha.pojo.dto.CurrencyTestData;
import per.ami.alpha.pojo.dto.GifTestData;
import per.ami.alpha.pojo.dto.InfoPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApiServiceTest {

    @MockBean
    private CurrencyServiceClient currencyServiceClient;

    @MockBean
    private GifServiceClient gifServiceClient;

    @Autowired
    ApiService apiService;

    @BeforeEach
    void setUp() {
        when(currencyServiceClient.getLastCurrencies()).thenReturn(CurrencyTestData.currency());
        when(currencyServiceClient.getYesterdayCurrencies(anyString())).thenReturn(CurrencyTestData.currency());
        when(gifServiceClient.getGif(anyString())).thenReturn(GifTestData.gif());
    }

    @Test
    void getPage() {
        InfoPage page = apiService.getPage("RATE1");
        assertThat(page.getGif()).isEqualTo("testurl");
        assertThat(page.getType()).isEqualTo("broke");
    }

    @Test
    void getStringPage() {
        String page = apiService.getStringPage("RATE1");
        assertThat(page).isEqualTo("<p>Type: broke</p><img src=testurl alt=\"No image :c\">");
    }
}