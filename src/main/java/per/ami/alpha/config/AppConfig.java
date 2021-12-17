package per.ami.alpha.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "proj")
public class AppConfig {

    private String name;
    private String environment;
    private boolean enabled;
    private API[] api;
    private String[] resources;
    private Currencyinfo currencyinfo;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String value) {
        this.environment = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public API[] getAPI() {
        return api;
    }

    public void setAPI(API[] value) {
        this.api = value;
    }

    public String[] getResources() {
        return resources;
    }

    public void setResources(String[] value) {
        this.resources = value;
    }

    public Currencyinfo getCurrencyinfo() {
        return currencyinfo;
    }

    public void setCurrencyinfo(Currencyinfo value) {
        this.currencyinfo = value;
    }
}

