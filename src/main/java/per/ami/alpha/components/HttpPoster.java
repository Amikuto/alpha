package per.ami.alpha.components;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpPoster {
    HttpURLConnection httpClient;

    HttpPoster() {

    }

    public String sendPost(String url) throws IOException {
        this.httpClient = (HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = httpClient.getResponseCode();
        if (responseCode == 200) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } else throw new IOException();
    }
}
