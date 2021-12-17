package per.ami.alpha.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import per.ami.alpha.pojo.dto.Currency;
import per.ami.alpha.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public Page<Currency> getPageCurrency(String currency) {
        PageRequest pageRequest = PageRequest.of(currentPage, pageSize);
        return null;
    }
}
