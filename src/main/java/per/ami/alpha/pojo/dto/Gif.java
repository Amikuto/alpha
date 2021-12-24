package per.ami.alpha.pojo.dto;

import lombok.*;

import java.util.Map;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Gif {
    @NonNull
    private GifData data;
    private Meta meta;

    @Data
    public static class Meta {
        private String msg;
        private long status;
        private String response_id;
    }

    @Data
    @RequiredArgsConstructor
    @NoArgsConstructor
    public static class GifData {
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
        @NonNull
        private GifImages images;
        private User user;

        @Data
        @NoArgsConstructor
        @RequiredArgsConstructor
        public static class GifImages {
            @NonNull
            private Map<String, String> original;
        }

        @Data
        public static class User {
            private String avatarURL;
            private String bannerImage;
            private String bannerURL;
            private String profileURL;
            private String username;
            private String displayName;
            private String description;
            private boolean isVerified;
            private String websiteURL;
            private String instagramURL;
        }
    }
}




