package per.ami.alpha.config;

import java.util.Map;

public class Currencyinfo {
    private String base;
    private Map<String, String> names;

    public String getBase() {
        return base;
    }

    public void setBase(String value) {
        this.base = value;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> value) {
        this.names = value;
    }
}
