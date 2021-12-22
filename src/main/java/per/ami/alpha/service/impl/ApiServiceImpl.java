package per.ami.alpha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ami.alpha.client.CurrencyServiceClient;
import per.ami.alpha.client.GifServiceClient;
import per.ami.alpha.pojo.dto.InfoPage;
import per.ami.alpha.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService {

//    @Autowired
//    AppConfig appConfig;
//
//    @Autowired
//    HttpPoster httpPoster;
//
//    @Autowired
//    CurrencyParser currencyParser;
//
//    @Override
//    public String getGif(String currency) throws IOException {
//
////        System.out.println(appConfig.getCurrencyinfo().getNames().get(currency));
//
//
//        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//        LocalDateTime ldt2 = LocalDateTime.now().minusDays(1);
////        String formatter2 = formmat.format(ldt2);
//
//        String type = "latest.json";
//        String date = formmat.format(ldt2);
//        String type2 = "historical/" + date + ".json";
//
//
//        String yest = appConfig.getApilinks().get("currency") + type2 + appConfig.getApikey().get("currency");
//        String today = appConfig.getApilinks().get("currency") + type + appConfig.getApikey().get("currency");
////        System.out.println(yest);
////        System.out.println(today);
//
//        String tag;
//        float currYesterday = CurrencyParser.parse(httpPoster.sendPost(yest), currency);
//        float currToday = CurrencyParser.parse(httpPoster.sendPost(today), currency);
//
//        System.out.println(currYesterday + " " +currToday);
//
//        if (currYesterday < currToday) {
//            tag = "rich";
//        } else {
//            tag = "broke";
//        }
//
//        String linkGif = appConfig.getApilinks().get("gif") + appConfig.getApikey().get("gif") + "&tag=" + tag;
//        return GifParser.parse(httpPoster.sendPost(linkGif));
//    }



    @Autowired
    CurrencyServiceClient currencyServiceClient;

    @Autowired
    GifServiceClient gifServiceClient;

    @Override
    public InfoPage getPage(String currency) {
        String gifType = "rich";
        String gifUrl = String.valueOf(gifServiceClient.getGif("rich").getData().getImages().getOriginal().get("url"));
        InfoPage infoPage = InfoPage.builder().url(gifUrl).type(gifType).build();
        return infoPage;
    }

    @Override
    public String getStringPage(String currency) {
        String gifType = "rich";
        String gifUrl = String.valueOf(gifServiceClient.getGif("rich").getData().getImages().getOriginal().get("url"));
        InfoPage infoPage = InfoPage.builder().url(gifUrl).type(gifType).build();
        return infoPage.toString();
    }
}

