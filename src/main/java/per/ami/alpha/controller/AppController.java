package per.ami.alpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.ami.alpha.client.CurrencyServiceClient;
import per.ami.alpha.client.GifServiceClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//@RestController
//@RequiredArgsConstructor
//public class AppController {
//
//    @Autowired
//    CurrencyService currencyService;
//
//    @GetMapping(value = "/info")
//    public ResponseEntity<String> showGif(@RequestParam("currency") String currency) throws IOException {
//        return ResponseEntity.ok().body("<img src=" + currencyService.getGif(currency) + " alt=\"Funny image\">");
//    }
//
//
//}

@RestController
public class AppController {

    @Autowired
    CurrencyServiceClient currencyServiceClient;

    @Autowired
    GifServiceClient gifServiceClient;

    @GetMapping("/getLastCurrency")
    public ResponseEntity<?> getLastCurrency() {
        return ResponseEntity.ok(currencyServiceClient.getLastCurrencies());
    }

    @GetMapping("/getYesterdayCurrency")
    public ResponseEntity<?> getYesterdayCurrency() {
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDateTime ldt2 = LocalDateTime.now().minusDays(1);
        String date = formmat.format(ldt2);
        return ResponseEntity.ok(currencyServiceClient.getYesterdayCurrencies(date));
    }

    @GetMapping("/api/info")
    public ResponseEntity<?> getGif() {
        return ResponseEntity.ok(gifServiceClient.getGif("rich"));
    }
}
