package per.ami.alpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.ami.alpha.config.AppConfig;
import per.ami.alpha.service.CurrencyService;

import java.io.IOException;

@RestController
public class CurrencyController {

    @Autowired
    AppConfig appConfig;

    @Autowired
    CurrencyService currencyService;

//    @Autowired
//    private MockMvc mockMvc;

    @GetMapping(value = "/info")
    public ResponseEntity<String> showGif(@RequestParam("currency") String currency) throws IOException {
//        currencyService.getGif(currency);

        return ResponseEntity.ok().body("<img src=" + currencyService.getGif(currency) + " alt=\"Funny image\">");//.body(message);
    }


}
