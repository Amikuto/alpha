package per.ami.alpha.pojo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class InfoPage {

    String url;
    String type;

    @Override
    public String toString() {
        return "<p>Type: " + type + "</p>" + "<img src=" + url + " alt=\"No image :c\">";
    }
}
