package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.MET.MetWeatherWebservice;
import com.example.weatherwebservice.SMHI.SmhiWeatherWebservice;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MetDto extends Dto {
    WebClient client = WebClient.create();
    MetWeatherWebservice metWeatherWebservice;

    public MetDto() {
        metWeatherWebservice= getInfoFromMet();
        temperature = getNextDayTemperature();
        humidity = getNextDayHumidity();
        time = getNextDayTime();
    }
    public MetWeatherWebservice getInfoFromMet() {
        Mono<MetWeatherWebservice> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(MetWeatherWebservice.class);
        return mono.block();
    }
    Integer getNextDayTemperature() {
        return 0;
    }

    Integer getNextDayHumidity() {
        return 0;
    }

    String getNextDayTime() {
        return "";
    }
}
