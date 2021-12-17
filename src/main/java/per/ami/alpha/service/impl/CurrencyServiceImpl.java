package per.ami.alpha.service.impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ami.alpha.config.AppConfig;
import per.ami.alpha.service.CurrencyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    AppConfig appConfig;

    @Override
    public String getGif(String currency) throws IOException {
//        Gif gif = Gif.builder().url("https://media1.giphy.com/media/WoRz0xf3fUBWTWXUJ0/giphy-downsized-large.gif?cid=34f66c658d2a0732af084571afee1d571d47c804e951ad6e&rid=giphy-downsized-large.gif&ct=g").build();

//        System.out.println(appConfig.getCurrencies().get(currency));
//        https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID
//        System.out.println();
//        Arrays.stream(appConfig.getAPI()).forEach(System.out::println);

        System.out.println(appConfig.getCurrencyinfo().getNames().get(currency));

        String type = "latest.json";
        String date = "2012-07-10";
        String type2 = "historical/" + date + ".json";
        String linkCurr = appConfig.getApilinks().get("currency") + type2 + appConfig.getApikey().get("currency");
        System.out.println(linkCurr);


        String tag = "rich";
        String linkGif = appConfig.getApilinks().get("gif") + appConfig.getApikey().get("gif") + "&tag=" + tag;
        System.out.println(linkGif);

//        String url = linkCurr;
//
//        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
//
//        // optional default is GET
//        httpClient.setRequestMethod("GET");
//
//        //add request header
//        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//        int responseCode = httpClient.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//
//        try (BufferedReader in = new BufferedReader(
//                new InputStreamReader(httpClient.getInputStream()))) {
//
//            StringBuilder response = new StringBuilder();
//            String line;
//
//            while ((line = in.readLine()) != null) {
//                response.append(line);
//            }

        String out = "{\n" +
                "disclaimer: \"Usage subject to terms: https://openexchangerates.org/terms\",\n" +
                "license: \"https://openexchangerates.org/license\",\n" +
                "timestamp: 1341936000,\n" +
                "base: \"USD\",\n" +
                "rates: {\n" +
                "AED: 3.672914,\n" +
                "AFN: 48.337601,\n" +
                "ALL: 111.863334,\n" +
                "AMD: 404.739995,\n" +
                "ANG: 1.7763,\n" +
                "AOA: 98.987999,\n" +
                "ARS: 4.535442,\n" +
                "AUD: 0.979838,\n" +
                "AWG: 1.7902,\n" +
                "AZN: 0.785521,\n" +
                "BAM: 1.598075,\n" +
                "BBD: 2,\n" +
                "BDT: 82.116967,\n" +
                "BGN: 1.593687,\n" +
                "BHD: 0.376992,\n" +
                "BIF: 1426.693333,\n" +
                "BMD: 1,\n" +
                "BND: 1.270462,\n" +
                "BOB: 6.996567,\n" +
                "BRL: 2.033216,\n" +
                "BSD: 1,\n" +
                "BTN: 55.399999,\n" +
                "BWP: 7.716432,\n" +
                "BYR: 8421.155,\n" +
                "BZD: 1.90755,\n" +
                "CAD: 1.020679,\n" +
                "CDF: 922.853699,\n" +
                "CHF: 0.979282,\n" +
                "CLF: 0.0218,\n" +
                "CLP: 493.98029,\n" +
                "CNY: 6.366196,\n" +
                "COP: 1793.01718,\n" +
                "CRC: 506.072719,\n" +
                "CVE: 90.560966,\n" +
                "CZK: 20.701607,\n" +
                "DJF: 178.013332,\n" +
                "DKK: 6.063057,\n" +
                "DOP: 39.16074,\n" +
                "DZD: 81.537585,\n" +
                "EGP: 6.060176,\n" +
                "ETB: 17.91345,\n" +
                "EUR: 0.81595,\n" +
                "FJD: 1.814441,\n" +
                "FKP: 0.644501,\n" +
                "GBP: 0.644691,\n" +
                "GEL: 1.728383,\n" +
                "GHS: 1.961133,\n" +
                "GIP: 0.635045,\n" +
                "GMD: 31.523967,\n" +
                "GNF: 7176.96,\n" +
                "GTQ: 7.84845,\n" +
                "GYD: 203.449998,\n" +
                "HKD: 7.754462,\n" +
                "HNL: 19.09924,\n" +
                "HRK: 6.105725,\n" +
                "HTG: 42.182233,\n" +
                "HUF: 234.753503,\n" +
                "IDR: 9433.299719,\n" +
                "IEP: 0.640661,\n" +
                "ILS: 3.961759,\n" +
                "INR: 55.410871,\n" +
                "IQD: 1165.99,\n" +
                "IRR: 12322.1,\n" +
                "ISK: 128.250001,\n" +
                "JMD: 88.599478,\n" +
                "JOD: 0.707902,\n" +
                "JPY: 79.419158,\n" +
                "KES: 84.016938,\n" +
                "KGS: 47.0575,\n" +
                "KHR: 4104.313333,\n" +
                "KMF: 401.696645,\n" +
                "KPW: 900,\n" +
                "KRW: 1141.143161,\n" +
                "KWD: 0.281625,\n" +
                "KZT: 150.225023,\n" +
                "LAK: 8041.109935,\n" +
                "LBP: 1505.608525,\n" +
                "LKR: 133.685111,\n" +
                "LRD: 74.850001,\n" +
                "LSL: 8.216633,\n" +
                "LTL: 2.81341,\n" +
                "LVL: 0.567011,\n" +
                "LYD: 1.26345,\n" +
                "MAD: 8.96912,\n" +
                "MDL: 12.326417,\n" +
                "MGA: 2249.006667,\n" +
                "MKD: 49.017402,\n" +
                "MMK: 886.29,\n" +
                "MNT: 1322.5,\n" +
                "MOP: 8.012017,\n" +
                "MRO: 294.944996,\n" +
                "MUR: 30.778471,\n" +
                "MVR: 15.336667,\n" +
                "MWK: 271.012505,\n" +
                "MXN: 13.324282,\n" +
                "MYR: 3.175228,\n" +
                "MZN: 27.928601,\n" +
                "NAD: 8.207706,\n" +
                "NGN: 161.234823,\n" +
                "NIO: 23.626774,\n" +
                "NOK: 6.097902,\n" +
                "NPR: 89.096712,\n" +
                "NZD: 1.257064,\n" +
                "OMR: 0.385082,\n" +
                "PAB: 1,\n" +
                "PEN: 2.6414,\n" +
                "PGK: 2.057068,\n" +
                "PHP: 41.842885,\n" +
                "PKR: 94.403581,\n" +
                "PLN: 3.41677,\n" +
                "PYG: 4508.143625,\n" +
                "QAR: 3.64125,\n" +
                "RON: 3.684737,\n" +
                "RSD: 94.284607,\n" +
                "RUB: 32.867934,\n" +
                "RWF: 611.527667,\n" +
                "SAR: 3.750239,\n" +
                "SBD: 7.341831,\n" +
                "SCR: 14.547331,\n" +
                "SDG: 3.557325,\n" +
                "SEK: 6.980154,\n" +
                "SGD: 1.267529,\n" +
                "SHP: 0.644501,\n" +
                "SLL: 4353.275363,\n" +
                "SOS: 1632.63,\n" +
                "SRD: 3.287171,\n" +
                "STD: 19858.156927,\n" +
                "SVC: 8.76897,\n" +
                "SYP: 64.505868,\n" +
                "SZL: 8.2171,\n" +
                "THB: 31.666759,\n" +
                "TJS: 4.9441,\n" +
                "TMT: 2.869713,\n" +
                "TND: 1.627575,\n" +
                "TOP: 1.802103,\n" +
                "TRY: 1.81875,\n" +
                "TTD: 6.408575,\n" +
                "TWD: 29.936053,\n" +
                "TZS: 1590.574012,\n" +
                "UAH: 8.118644,\n" +
                "UGX: 2477.31895,\n" +
                "USD: 1,\n" +
                "UYU: 21.952012,\n" +
                "UZS: 1897.444839,\n" +
                "VEF: 4.291999,\n" +
                "VND: 20913.643325,\n" +
                "VUV: 91.625,\n" +
                "WST: 2.390471,\n" +
                "XAF: 535.452749,\n" +
                "XCD: 2.768217,\n" +
                "XDR: 0.664376,\n" +
                "XOF: 535.545004,\n" +
                "XPF: 97.410067,\n" +
                "YER: 215.003059,\n" +
                "ZAR: 8.201748,\n" +
                "ZMK: 4715.31642,\n" +
                "ZWD: 361.898139,\n" +
                "ZWL: 322.355011\n" +
                "}\n" +
                "}";

        //print result
        JSONObject jsonObject = new JSONObject(out);
        JSONObject jsonObject1 = jsonObject.getJSONObject("rates");
        BigDecimal fl = (BigDecimal) jsonObject1.get(currency);
        System.out.println(fl);


        return "gif.getUrl()";
    }
}

