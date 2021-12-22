package per.ami.alpha.pojo.dto;

import lombok.Data;

@Data
public class Gif {
    private GifData data;
    private Meta meta;

    @Data
    private static class Meta {
        private String msg;
        private long status;
        private String response_id;
    }

    @Data
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
        private Object images;
        private User user;

        @Data
        private static class User {
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

//        private static class Images {
//            private The480_WStill downsizedLarge;
//            private The480_WStill fixedHeightSmallStill;
//            private FixedHeight original;
//            private FixedHeight fixedHeightDownsampled;
//            private The480_WStill downsizedStill;
//            private The480_WStill fixedHeightStill;
//            private The480_WStill downsizedMedium;
//            private The480_WStill downsized;
//            private The480_WStill previewWebp;
//            private DownsizedSmall originalMp4;
//            private FixedHeight fixedHeightSmall;
//            private FixedHeight fixedHeight;
//            private DownsizedSmall downsizedSmall;
//            private DownsizedSmall preview;
//            private FixedHeight fixedWidthDownsampled;
//            private The480_WStill fixedWidthSmallStill;
//            private FixedHeight fixedWidthSmall;
//            private The480_WStill originalStill;
//            private The480_WStill fixedWidthStill;
//            private Looping looping;
//            private FixedHeight fixedWidth;
//            private The480_WStill previewGIF;
//            private The480_WStill the480WStill;
//        }
    }

}



