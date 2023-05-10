package com.example.weatherwebservice;

import com.example.weatherwebservice.SMHI.Geometry;
import com.example.weatherwebservice.SMHI.WeatherWebservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class Client implements CommandLineRunner {
    WebClient client = WebClient.create();

    public WeatherWebservice getSmhi() {
        Mono<WeatherWebservice> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(WeatherWebservice.class);
        return mono.block();
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(getSmhi().getTimeSeries());
        System.out.println(getSmhi().getApprovedTime());
        System.out.println(getSmhi().getTimeSeries().get(0).getParameters().get(10).getValues());
    }
}