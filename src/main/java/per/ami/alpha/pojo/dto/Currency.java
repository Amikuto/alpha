package per.ami.alpha.pojo.dto;

import lombok.Data;

@Data
public class Currency {
    private String shortName;
    private String fullName;
    private Float cost;
}
