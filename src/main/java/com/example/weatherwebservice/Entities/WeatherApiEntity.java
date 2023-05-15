package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.WeatherAPIClient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class WeatherApiEntity extends WeatherWebsiteEntity {
    WeatherAPIClient weatherAPIClient;
    int day = 0;
    int currentHour = 0;
    LocalDateTime timeNow = LocalDateTime.now();

    public WeatherApiEntity() {
        weatherAPIClient = new WeatherAPIClient();
        weatherSource = "WeatherAPI";
        updateInformation();
    }

    public void updateInformation(){
        temperature = getTemperatureByTime(hour);
        humidity = getHumidityByTime(hour);
        time = getTimeByWeatherApi(hour);
    }

    void findHours() {
        timeNow = LocalDateTime.now();
        currentHour = timeNow.getHour();
        day = 0;
        while ((currentHour + hour) > 24) {
            day++;
            hour = -24;
        }
    }

    private Integer getHumidityByTime(int hour) {
        findHours();
        return weatherAPIClient.weatherAPIService.getForecast().getForecastday().get(day).getHour().get(hour).getHumidity();
    }

    private Integer getTemperatureByTime(int hour) {
        findHours();
        return weatherAPIClient.weatherAPIService.getForecast().getForecastday().get(day).getHour().get(currentHour + hour).getTempC().intValue();
    }

    public LocalDateTime getTimeByWeatherApi(int hour) {
        findHours();
        return LocalDateTime.parse(weatherAPIClient.weatherAPIService.getForecast().getForecastday().get(day).getHour().get(currentHour + hour).getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
