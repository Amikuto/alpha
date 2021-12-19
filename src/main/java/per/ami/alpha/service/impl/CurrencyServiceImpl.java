package per.ami.alpha.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ami.alpha.components.CurrencyParser;
import per.ami.alpha.components.GifParser;
import per.ami.alpha.components.HttpPoster;
import per.ami.alpha.config.AppConfig;
import per.ami.alpha.service.CurrencyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    AppConfig appConfig;

    @Autowired
    HttpPoster httpPoster;

    @Autowired
    CurrencyParser currencyParser;

    @Override
    public String getGif(String currency) throws IOException {

        System.out.println(appConfig.getCurrencyinfo().getNames().get(currency));


        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDateTime ldt2 = LocalDateTime.now().minusDays(1);
//        String formatter2 = formmat.format(ldt2);

        String type = "latest.json";
        String date = formmat.format(ldt2);
        String type2 = "historical/" + date + ".json";


        String yest = appConfig.getApilinks().get("currency") + type2 + appConfig.getApikey().get("currency");
        String today = appConfig.getApilinks().get("currency") + type + appConfig.getApikey().get("currency");
        System.out.println(yest);
        System.out.println(today);

        String tag;
        float currYesterday = CurrencyParser.parse(httpPoster.sendPost(yest), currency);
        float currToday = CurrencyParser.parse(httpPoster.sendPost(today), currency);

        System.out.println(currYesterday + " " +currToday);

        if (currYesterday < currToday) {
            tag = "rich";
        } else {
            tag = "broke";
        }

        String linkGif = appConfig.getApilinks().get("gif") + appConfig.getApikey().get("gif") + "&tag=" + tag;
        return GifParser.parse(httpPoster.sendPost(linkGif));
    }
}

