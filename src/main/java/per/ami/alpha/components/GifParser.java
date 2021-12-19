package per.ami.alpha.components;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class GifParser {

    public static String parse(String stringToParse) {
        JSONObject jsonObject = new JSONObject(stringToParse);
        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
        JSONObject jsonObject2 = jsonObject1.getJSONObject("images");
        JSONObject jsonObject3 = jsonObject2.getJSONObject("downsized_large");
        return (jsonObject3.get("url").toString());
    }
}
