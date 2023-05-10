package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.MET.MetWeatherWebservice;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class MetDto extends WeatherWebsiteDto {
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
        return metWeatherWebservice.getProperties().getTimeseries().get(27).getData().getInstant().getDetails().getAirTemperature().intValue();
    }

    Integer getNextDayHumidity() {
        return metWeatherWebservice.getProperties().getTimeseries().get(27).getData().getInstant().getDetails().getRelativeHumidity().intValue();
    }

    String getNextDayTime() {
        return metWeatherWebservice.getProperties().getTimeseries().get(27).getTime();
    }
}
