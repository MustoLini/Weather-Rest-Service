package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.SMHI.WeatherWebservice;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MetDto extends Dto {
    WebClient client = WebClient.create();

    public MetDto() {
        Mono<WeatherWebservice> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(WeatherWebservice.class);
    }
}
