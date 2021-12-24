package per.ami.alpha.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.ami.alpha.service.ApiService;

@RestController
public class AppController {

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
