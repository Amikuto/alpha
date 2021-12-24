package per.ami.alpha.pojo.dto;

import java.util.HashMap;
import java.util.Map;


public class CurrencyTestData {

    public static Currency currency() {
        Map<String, Float> rates = new HashMap<>();
        rates.put("RATE1", 1f);
        rates.put("RATE2", 2f);
        rates.put("RATE3", 3f);

        return new Currency("disclaimer", "license", 123L, "base", rates);
    }

}