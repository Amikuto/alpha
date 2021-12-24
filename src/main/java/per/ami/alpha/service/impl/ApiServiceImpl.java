package per.ami.alpha.service.impl;

import org.springframework.stereotype.Service;
import per.ami.alpha.client.CurrencyServiceClient;
import per.ami.alpha.client.GifServiceClient;
import per.ami.alpha.pojo.dto.InfoPage;
import per.ami.alpha.service.ApiService;
import per.ami.alpha.utils.MyDateFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class ApiServiceImpl implements ApiService {

    CurrencyServiceClient currencyServiceClient;
    GifServiceClient gifServiceClient;

    ApiServiceImpl(CurrencyServiceClient currencyServiceClient, GifServiceClient gifServiceClient) {
        this.currencyServiceClient = currencyServiceClient;
        this.gifServiceClient = gifServiceClient;
    }

    @Override
    public InfoPage getPage(String currency) {
        String gifType = "rich";
        String gifUrl = gifServiceClient.getGif("rich").getData().getImages().getOriginal().get("url");
        InfoPage infoPage = InfoPage.builder().url(gifUrl).type(gifType).build();
        return infoPage;
    }

    @Override
    public String getStringPage(String currency) {

        DateTimeFormatter currencyApiDF = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);


        Float todayCurr = currencyServiceClient.getLastCurrencies().getRates().get(currency);
//        Float yestCurr = currencyServiceClient.getYesterdayCurrencies(currencyApiDF.format(yesterday)).getRates().get(currency);

        MyDateFormatter myDF = new MyDateFormatter();
        Float yestCurr = currencyServiceClient.getYesterdayCurrencies(myDF.getYesterday()).getRates().get(currency);


        String gifType;
        if (yestCurr < todayCurr) {
            gifType = "rich";
        } else {
            gifType = "broke";
        }

        String gifUrl = gifServiceClient.getGif(gifType).getData().getImages().getOriginal().get("url");
        InfoPage infoPage = InfoPage.builder().url(gifUrl).type(gifType).build();
        return infoPage.toString();
    }
}

