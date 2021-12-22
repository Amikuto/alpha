package per.ami.alpha.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.ami.alpha.pojo.dto.Currency;

@FeignClient(name = "currency-service", url = "https://openexchangerates.org/api/")
public interface CurrencyServiceClient {

    @RequestMapping(value = "/latest.json?app_id=e959952041104d32a28d938729bcffbf", method = RequestMethod.GET)
    public Currency getLastCurrencies();

    @RequestMapping(value = "/historical/{date}.json?app_id=e959952041104d32a28d938729bcffbf", method = RequestMethod.GET)
    public Currency getYesterdayCurrencies(@PathVariable String date);
}
