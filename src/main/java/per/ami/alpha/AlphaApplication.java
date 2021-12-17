package per.ami.alpha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AlphaApplication {

    @Autowired
    private AppConfig appConfig;

    @PostConstruct
    void print() {
        System.out.println("using environment: " + appConfig.getEnvironment());
        System.out.println("name: " + appConfig.getName());
        System.out.println("enabled:" + appConfig.isEnabled());
        System.out.println("resources: " + appConfig.getResources());
        System.out.println("currencies: " + appConfig.getCurrencies());
    }

    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
    }

}
