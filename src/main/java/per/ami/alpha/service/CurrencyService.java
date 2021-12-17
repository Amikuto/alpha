package per.ami.alpha.service;

import per.ami.alpha.pojo.dto.Currency;

import java.io.IOException;
import java.net.MalformedURLException;

public interface CurrencyService {
    String getGif(String currency) throws IOException;
}
