package per.ami.alpha.pojo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
public class Gif {
    private GifData data;
    private Meta meta;
}

@Data
class Meta {
    private String msg;
    private long status;
    private String response_id;
}

@Data
class User {
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
//    }
//
//}



