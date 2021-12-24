package per.ami.alpha.pojo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class InfoPage {

    String gif;
    String type;

    @Override
    public String toString() {
        return "<p>Type: " + type + "</p>" + "<img src=" + gif + " alt=\"No image :c\">";
    }
}
