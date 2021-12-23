package per.ami.alpha.pojo.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyTestData {

    public static Currency currency() {
        Map<String, Float> rates = new HashMap<>();
        rates.put("RATE1", 1f);
        rates.put("RATE2", 2f);
        rates.put("RATE3", 3f);
//        Currency currency = new Currency();
//        currency.setDisclaimer("disclaimer");
//        currency.setLicense("license");
//        currency.setTimestamp(123L);
//        currency.setBase("base");
//        currency.setRates(rates);
//        return currency;
//        Long f = new Long(1);
//        new Currency("d", "l", f, "b", rates);

        return new Currency("disclaimer", "license", 123L, "base", rates);
    }

    public static List<Currency> currencies() {
        return List.of(currency());
    }

}