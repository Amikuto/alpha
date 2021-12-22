package per.ami.alpha.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.ami.alpha.pojo.dto.Currency;
import per.ami.alpha.pojo.dto.Gif;

@FeignClient(name = "gif-service", url = "https://api.giphy.com/v1/gifs/")
public interface GifServiceClient {

    @RequestMapping(value = "/random?api_key=17SnwbepiIKuHeTg4yOxDk06QIbCZCe7&tag={tag}", method = RequestMethod.GET)
    public Gif getGif(@PathVariable String tag);
}
