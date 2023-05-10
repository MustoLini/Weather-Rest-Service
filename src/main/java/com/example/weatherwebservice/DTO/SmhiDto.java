package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.SMHI.SmhiWeatherWebservice;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class SmhiDto extends WeatherWebsiteDto {
    WebClient client = WebClient.create();
    SmhiWeatherWebservice weatherWebservice;

    public SmhiDto() {

        weatherWebservice = getInfoFromSmhi();
        temperature = getNextDayTemperature();
        humidity = getNextDayHumidity();
        time = getNextDayTime();
    }

    public SmhiWeatherWebservice getInfoFromSmhi() {
        Mono<SmhiWeatherWebservice> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(SmhiWeatherWebservice.class);
        return mono.block();
    }

    Integer getNextDayTemperature() {
        return weatherWebservice.getTimeSeries().get(25).getParameters().get(10).getValues().get(0);
    }

    Integer getNextDayHumidity() {
        return weatherWebservice.getTimeSeries().get(25).getParameters().get(15).getValues().get(0);
    }

    String getNextDayTime() {
        return weatherWebservice.getTimeSeries().get(25).getValidTime();
    }

}
