package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.MetClient;
import com.example.weatherwebservice.ClientsManagment.WeatherAPIClient;
import com.example.weatherwebservice.WeatherApi.WeatherAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WeatherApiEntity extends WeatherWebsiteEntity{
    WeatherAPIClient weatherAPIClient;
    public WeatherApiEntity() {
        weatherAPIClient = new WeatherAPIClient();
        temperature = getTemperatureByTime(hour);
        humidity = getHumidityByTime(hour);
        time = getTimeByWeatherApi(hour);
        weatherSource = "MET";
    }

    private Integer getHumidityByTime(int hour) {

    }

    private Integer getTemperatureByTime(int hour) {
        return null;
    }
    public LocalDateTime getTimeByWeatherApi(int hour){
        return LocalDateTime.parse(weatherAPIClient.weatherAPIService.getForecast().);    }
}
