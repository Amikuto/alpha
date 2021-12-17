package per.ami.alpha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.ami.alpha.config.AppConfig;
import per.ami.alpha.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    AppConfig appConfig;

    @Override
    public String getGif(String currency) {
//        Gif gif = Gif.builder().url("https://media1.giphy.com/media/WoRz0xf3fUBWTWXUJ0/giphy-downsized-large.gif?cid=34f66c658d2a0732af084571afee1d571d47c804e951ad6e&rid=giphy-downsized-large.gif&ct=g").build();

//        System.out.println(appConfig.getCurrencies().get(currency));
//        https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID
        System.out.println(appConfig.getCurrencyinfo().getBase());

        return "gif.getUrl()";
    }
}
