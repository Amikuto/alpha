package per.ami.alpha.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Currency {
    String disclaimer;
    String license;
    Long timestamp;
    String base;
    Map<String, Float> rates;
}
