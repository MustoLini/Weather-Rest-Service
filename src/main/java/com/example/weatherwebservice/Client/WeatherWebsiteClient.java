package com.example.weatherwebservice.Client;

abstract public class WeatherWebsiteClient {

    Integer temperature;
    Integer humidity;
    String time;


    public WeatherWebsiteClient() {
    }

    public WeatherWebsiteClient(Integer temperature, Integer humidity, String time) {
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
