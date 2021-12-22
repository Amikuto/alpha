package per.ami.alpha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import per.ami.alpha.config.AppConfig;

@SpringBootApplication
@ServletComponentScan
//@EnableFeignClients
@EnableFeignClients
public class AlphaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaApplication.class, args);
    }

}
