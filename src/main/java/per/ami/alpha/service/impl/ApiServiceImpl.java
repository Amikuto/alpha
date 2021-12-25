package per.ami.alpha.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import per.ami.alpha.client.CurrencyServiceClient;
import per.ami.alpha.client.GifServiceClient;
import per.ami.alpha.pojo.dto.InfoPage;
import per.ami.alpha.service.ApiService;
import per.ami.alpha.utils.MyDateFormatter;

@Slf4j
@Service
public class ApiServiceImpl implements ApiService {

    private final CurrencyServiceClient currencyServiceClient;
    private final GifServiceClient gifServiceClient;

    ApiServiceImpl(CurrencyServiceClient currencyServiceClient, GifServiceClient gifServiceClient) {
        this.currencyServiceClient = currencyServiceClient;
        this.gifServiceClient = gifServiceClient;
    }

    @Override
    public InfoPage getPage(String currency) {
        InfoPage infoPage = getGifUrl(currency);
        log.info("\nТекущая гиффка: " + infoPage.getGif() + "\nТип: " + infoPage.getType());
        return infoPage;
    }

    @Override
    public String getStringPage(String currency) {
        return getGifUrl(currency).toString();
    }

    private InfoPage getGifUrl(String currency) {
        Float todayCurr = currencyServiceClient.getLastCurrencies().getRates().get(currency);
        MyDateFormatter myDF = new MyDateFormatter();
        Float yestCurr = currencyServiceClient.getYesterdayCurrencies(myDF.getYesterday()).getRates().get(currency);

        String gifType;
        if (yestCurr < todayCurr) {
            gifType = "rich";
        } else {
            gifType = "broke";
        }

        String gifUrl = gifServiceClient.getGif(gifType).getData().getImages().getOriginal().get("url");
        InfoPage infoPage = InfoPage.builder().gif(gifUrl).type(gifType).build();
        return infoPage;
    }
}

