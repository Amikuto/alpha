package per.ami.alpha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.ami.alpha.service.ApiService;

@RestController
public class AppController {

//    @Autowired
//    CurrencyServiceClient currencyServiceClient;
//
//    @Autowired
//    GifServiceClient gifServiceClient;

//    @GetMapping("/getLastCurrency")
//    public ResponseEntity<?> getLastCurrency() {
//        return ResponseEntity.ok(currencyServiceClient.getLastCurrencies());
//    }
//
//    @GetMapping("/getYesterdayCurrency")
//    public ResponseEntity<?> getYesterdayCurrency() {
//        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//        LocalDateTime ldt2 = LocalDateTime.now().minusDays(1);
//        String date = formmat.format(ldt2);
//        return ResponseEntity.ok(currencyServiceClient.getYesterdayCurrencies(date));
//    }
//
//    @GetMapping("/getGif")
//    public ResponseEntity<?> getGif() {
//        return ResponseEntity.ok(gifServiceClient.getGif("rich"));
//    }

    ApiService apiService;

    AppController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/api/info")
    public ResponseEntity<?> getInfoGif(@RequestParam("currency") String currency) {
        return ResponseEntity.ok(apiService.getPage(currency));
    }

    @GetMapping("/api/string/info")
    public ResponseEntity<?> getInfoGifString(@RequestParam("currency") String currency) {
        return ResponseEntity.ok(apiService.getStringPage(currency));
    }
}
