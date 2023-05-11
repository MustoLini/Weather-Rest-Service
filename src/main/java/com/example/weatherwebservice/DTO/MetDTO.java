package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.Client.MetClient;
import com.example.weatherwebservice.MET.MetWeatherWebservice;

public class MetDTO extends WeatherWebsiteDTO {
    MetClient metClient;
    public MetDTO() {
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

    String getNextDayTime() {
        return metClient.metWeatherWebservice.getProperties().getTimeseries().get(27).getTime();
    }
}
