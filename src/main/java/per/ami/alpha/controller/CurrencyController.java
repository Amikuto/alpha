package per.ami.alpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.ami.alpha.AppConfig;
import per.ami.alpha.pojo.dto.Currency;
import per.ami.alpha.pojo.dto.Message;
import per.ami.alpha.service.CurrencyService;

@RestController
public class CurrencyController {

    @Autowired
    AppConfig appConfig;

    @Autowired
    CurrencyService currencyService;

//    @Autowired
//    private MockMvc mockMvc;

    @GetMapping(value = "/info")
    public ResponseEntity<Message> showGif(@RequestParam("currency") String currency) {

        Page<Currency> resourcePage = currencyService.getPageCurrency(currency);
        Message message = Message.builder().data(resourcePage).build();

        return ResponseEntity.ok().body(message);
    }


}
