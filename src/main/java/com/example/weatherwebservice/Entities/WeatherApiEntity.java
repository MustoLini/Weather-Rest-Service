package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.MetClient;
import com.example.weatherwebservice.ClientsManagment.WeatherAPIClient;
import com.example.weatherwebservice.WeatherApi.WeatherAPI;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Component
public class WeatherApiEntity extends WeatherWebsiteEntity{
    WeatherAPIClient weatherAPIClient;
    public WeatherApiEntity() {
        weatherAPIClient = new WeatherAPIClient();
        temperature = getTemperatureByTime(hour);
        humidity = getHumidityByTime(hour);
        time = getTimeByWeatherApi(hour);
        weatherSource = "WeatherAPI";
    }

    private Integer getHumidityByTime(int hour) {
        LocalDateTime timeNow = LocalDateTime.now();
        int currentHour = timeNow.getHour();
        int day = 0;
        while((currentHour+hour)>24){
            day++;
            hour=-24;
        }
        return weatherAPIClient.weatherAPIService.getForecast().getForecastday().get(day).getHour().get(hour).getHumidity();
    }

    private Integer getTemperatureByTime(int hour) {
        LocalDateTime timeNow = LocalDateTime.now();
        int currentHour = timeNow.getHour();
        int day = 0;
        while((currentHour+hour)>24){
            day++;
            hour=-24;
        }

        return weatherAPIClient.weatherAPIService.getForecast().getForecastday().get(day).getHour().get(hour).getTempC().intValue();
    }
    public LocalDateTime getTimeByWeatherApi(int hour){
        LocalDateTime timeNow = LocalDateTime.now();
        int currentHour = timeNow.getHour();
        int day = 0;
        while((currentHour+hour)>24){
            day++;
            hour=-24;
        }

        return LocalDateTime.parse(weatherAPIClient.weatherAPIService.getForecast().getForecastday().get(day).getHour().get(currentHour+hour).getTime(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        }
}
