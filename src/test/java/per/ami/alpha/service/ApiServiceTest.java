package per.ami.alpha.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import per.ami.alpha.client.CurrencyFeignClient;
import per.ami.alpha.client.CurrencyServiceClient;
import per.ami.alpha.client.GifServiceClient;
import per.ami.alpha.pojo.dto.CurrencyTestData;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ApiServiceTest {

    @MockBean
    private CurrencyServiceClient currencyServiceClient;

    @MockBean
    private GifServiceClient gifServiceClient;

    @Autowired
    ApiService apiService;

    @Test
    void getPage() {
        when(currencyServiceClient.getLastCurrencies()).thenReturn(CurrencyTestData.currency());
    }

    @Test
    void getStringPage() {
    }
}