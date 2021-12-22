package per.ami.alpha.utils;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MyDateFormatter implements Formatter<Date> {
    String pattern = "yyyy-MM-dd";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
    LocalDateTime today = LocalDateTime.now();
    LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

    public MyDateFormatter() {}

    public String getYesterday() {
        return formatter.format(yesterday);
    }

    protected DateFormat getDateFormat(Locale locale) {
        DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
        dateFormat.setLenient(false);
        return dateFormat;
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Date object, Locale locale) {
        return null;
    }
}
