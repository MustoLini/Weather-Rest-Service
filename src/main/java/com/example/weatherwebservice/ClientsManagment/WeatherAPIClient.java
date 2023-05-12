package com.example.weatherwebservice.ClientsManagment;

import com.example.weatherwebservice.MET.MetWeatherWebservice;
import com.example.weatherwebservice.WeatherApi.WeatherAPI;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WeatherAPIClient {
    WebClient client = WebClient.create();
    public WeatherAPI weatherAPIService;

    public WeatherAPIClient() {
        weatherAPIService= getInfoFromMet();
    }
    public WeatherAPI getInfoFromMet() {
        Mono<WeatherAPI> mono = client
                .get()
                .uri("https://weatherapi-com.p.rapidapi.com/forecast.json?q=stockholm&days=2")
                .header("X-RapidAPI-Key", "fcaef57317msh42d91842ac6e048p136bedjsn8f84c70c95c5")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .retrieve()
                .bodyToMono(WeatherAPI.class);
        return mono.block();
    }
}
