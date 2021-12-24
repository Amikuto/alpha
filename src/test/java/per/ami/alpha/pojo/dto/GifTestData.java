package per.ami.alpha.pojo.dto;

import java.util.HashMap;
import java.util.Map;

public class GifTestData {

    public static Gif gif() {
//        Gif.Meta meta = ;
        Map<String, String> original = new HashMap<>();
        original.put("url", "testurl");
        return new Gif(new Gif.GifData(new Gif.GifData.GifImages(original)), new Gif.Meta());
    }

//    public static
}
