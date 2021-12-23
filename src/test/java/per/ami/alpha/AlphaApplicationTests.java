package per.ami.alpha;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import per.ami.alpha.controller.AppController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AlphaApplicationTests {

    @Autowired
    private AppController appController;

    @Test
    void contextLoads() {
        assertThat(appController).isNotNull();
    }

}
