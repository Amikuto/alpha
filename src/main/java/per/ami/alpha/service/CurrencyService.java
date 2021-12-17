package per.ami.alpha.service;

import org.springframework.data.domain.Page;
import per.ami.alpha.pojo.dto.Currency;

public interface CurrencyService {

    Page<Currency> getPageCurrency(String currency);
}
