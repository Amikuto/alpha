package per.ami.alpha.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.ami.alpha.pojo.dto.Currency;
import per.ami.alpha.pojo.dto.Gif;

@FeignClient(name = "${app.feign.config.name.gif}", url = "${app.feign.config.url.gif}")
public interface GifServiceClient {

    @RequestMapping(value = "/random?api_key=${app.feign.config.token.gif}&tag={tag}", method = RequestMethod.GET)
    Gif getGif(@PathVariable String tag);
}
