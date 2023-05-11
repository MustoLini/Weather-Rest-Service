package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.MetClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    }

    Integer getNextDayTemperature() {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getData().getInstant().getDetails().getAirTemperature().intValue();
    }

    Integer getNextDayHumidity() {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getData().getInstant().getDetails().getRelativeHumidity().intValue();
    }

    LocalDateTime getNextDayTime() {
        return LocalDateTime.parse(metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getTime(), DateTimeFormatter.ISO_DATE_TIME);
    }
}
