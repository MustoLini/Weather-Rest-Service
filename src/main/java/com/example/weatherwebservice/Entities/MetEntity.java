package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.MetClient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MetEntity extends WeatherWebsiteEntity {
    MetClient metClient;

    public MetEntity() {
        metClient = new MetClient();
        temperature = getNextDayTemperature();
        humidity = getNextDayHumidity();
        time = getNextDayTime();
        weatherSource = "MET";
    }


    public LocalDateTime modularTime(Integer hours) {
        return LocalDateTime.parse(metClient.metWeatherWebservice.getProperties().getTimeseries().get(hours).getTime(), DateTimeFormatter.ISO_DATE_TIME);
    }

    public Integer getNextDayTemperature() {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getData().getInstant().getDetails().getAirTemperature().intValue();
    }

    public Integer getNextDayHumidity() {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getData().getInstant().getDetails().getRelativeHumidity().intValue();
    }

    public LocalDateTime getNextDayTime() {
        return LocalDateTime.parse(metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getTime(), DateTimeFormatter.ISO_DATE_TIME);
    }
}
