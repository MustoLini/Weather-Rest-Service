package com.example.weatherwebservice.ClientsManagment;

import com.example.weatherwebservice.MET.MetWeatherWebservice;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class MetClient {
    WebClient client = WebClient.create();
    public MetWeatherWebservice metWeatherWebservice;

    public MetClient() {
        metWeatherWebservice= getInfoFromMet();
    }
    public MetWeatherWebservice getInfoFromMet() {
        Mono<MetWeatherWebservice> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(MetWeatherWebservice.class);
        return mono.block();
    }
}
