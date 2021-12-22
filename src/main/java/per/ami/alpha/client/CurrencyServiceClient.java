package per.ami.alpha.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.ami.alpha.pojo.dto.Currency;

@FeignClient(name = "${app.feign.config.name.currency}", url = "${app.feign.config.url.currency}", fallback = CurrencyServiceFallback.class)
public interface CurrencyServiceClient {

    @RequestMapping(value = "/latest.json?app_id=${app.feign.config.token.currency}", method = RequestMethod.GET)
    Currency getLastCurrencies();

    @RequestMapping(value = "/historical/{date}.json?app_id=${app.feign.config.token.currency}", method = RequestMethod.GET)
    Currency getYesterdayCurrencies(@PathVariable String date);
}
