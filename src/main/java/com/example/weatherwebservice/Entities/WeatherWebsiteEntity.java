package com.example.weatherwebservice.Entities;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

abstract public class WeatherWebsiteEntity {
    public Integer temperature;
    public Integer humidity;
    public LocalDateTime time;


    public WeatherWebsiteEntity() {
    }

    public WeatherWebsiteEntity(Integer temperature, Integer humidity, LocalDateTime time) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.time = time;

    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
