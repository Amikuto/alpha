package per.ami.alpha.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MyDateFormatter {
    String pattern = "yyyy-MM-dd";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
    LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

    public MyDateFormatter() {}

    public String getYesterday() {
        return formatter.format(yesterday);
    }
}
