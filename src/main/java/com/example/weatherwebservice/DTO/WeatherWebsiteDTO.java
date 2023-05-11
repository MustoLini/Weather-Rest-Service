package com.example.weatherwebservice.DTO;

abstract public class WeatherWebsiteDTO {
    public Integer temperature;
    public Integer humidity;
    public String time;


    public WeatherWebsiteDTO() {
    }

    public WeatherWebsiteDTO(Integer temperature, Integer humidity, String time) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
