package per.ami.alpha.components;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyParser {

    public static float parse(String stringToParse, String currency) {
        JSONObject jsonObject = new JSONObject(stringToParse);
        JSONObject jsonObject1 = jsonObject.getJSONObject("rates");
        BigDecimal fl = (BigDecimal) jsonObject1.get(currency);
        return Float.parseFloat(String.valueOf(fl));
    }
}
