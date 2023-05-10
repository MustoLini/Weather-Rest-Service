package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.SMHI.WeatherWebservice;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class SmhiDto extends Dto {
    WebClient client = WebClient.create();
    WeatherWebservice weatherWebservice;

    public SmhiDto() {

        weatherWebservice=getInfoFromSmhi();
        temperature= weatherWebservice.getTimeSeries().get(0).getParameters().get(10).getValues().get(0);

    }
    public WeatherWebservice getInfoFromSmhi(){
        Mono<WeatherWebservice> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(WeatherWebservice.class);
         return mono.block();
    }


}
