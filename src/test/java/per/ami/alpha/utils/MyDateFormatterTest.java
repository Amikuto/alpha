package per.ami.alpha.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class MyDateFormatterTest {

    @Test
    void getYesterday() {
        MyDateFormatter myDateFormatter = new MyDateFormatter();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

        assertThat(yesterday.format(formatter)).isEqualTo(myDateFormatter.getYesterday());

    }
}