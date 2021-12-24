//package per.ami.alpha.client;
//
//import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
//import org.springframework.stereotype.Component;
//import per.ami.alpha.pojo.dto.Currency;
//
//@Component
//public class CurrencyServiceFallback implements CurrencyServiceClient {
//    @Override
//    public Currency getLastCurrencies() {
//        throw new NoFallbackAvailableException("Boom!", new RuntimeException());
//    }
//
//    @Override
//    public Currency getYesterdayCurrencies(String date) {
//        return null;
//    }
//}
