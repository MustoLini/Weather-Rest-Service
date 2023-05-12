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
        temperature = getTemperatureByTime(hour);
        humidity = getHumidityByTime(hour);
        time = getTimeByMet(hour);
        weatherSource = "MET";
    }



    public Integer getTemperatureByTime(int hour) {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(hour+3).getData().getInstant().getDetails().getAirTemperature().intValue();
    }

    public Integer getHumidityByTime(int hour) {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(hour+3).getData().getInstant().getDetails().getRelativeHumidity().intValue();
    }

    public LocalDateTime getTimeByMet(int hour){
        return LocalDateTime.parse(metClient.metWeatherWebservice.getProperties().getTimeseries().get(hour+3).getTime(), DateTimeFormatter.ISO_DATE_TIME);
    }

}
