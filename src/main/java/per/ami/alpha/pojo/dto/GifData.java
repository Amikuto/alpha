package per.ami.alpha.pojo.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class GifData {
    private String type;
    private String id;
    private String url;
    private String slug;
    private String bitly_gif_url;
    private String bitly_url;
    private String embed_url;
    private String username;
    private String source;
    private String title;
    private String rating;
    private String content_url;
    private String source_tld;
    private String source_post_url;
    private long is_sticker;
    private String import_datetime;
    private String trending_datetime;
    private GifImages images;
    private User user;
}
