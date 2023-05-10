package com.example.weatherwebservice.DTO;

import java.util.List;

abstract public class Dto {

    Integer temperature;
    double humidity;
    String time;
    String location;

    public Dto() {
    }

    public Dto(Integer temperature, double humidity, String time, String location) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.time = time;
        this.location = location;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}