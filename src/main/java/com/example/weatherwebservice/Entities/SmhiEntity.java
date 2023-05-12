package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.SmhiClient;
import com.example.weatherwebservice.SMHI.Parameter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SmhiEntity extends WeatherWebsiteEntity {
    SmhiClient smhiClient;



    public SmhiEntity() {
        smhiClient = new SmhiClient();
        temperature = getTemperatureByTime(hour);
        humidity = getHumidityByTime(hour);
        time = getTime(hour);
        weatherSource = "SMHI";
    }


    public LocalDateTime getTime(int hour) {

        return LocalDateTime.parse(smhiClient.weatherWebservice.getTimeSeries().get(hour+1).getValidTime(), DateTimeFormatter.ISO_DATE_TIME);
    }

    public Integer getTemperatureByTime(int hour) {
        int temperature = 0;
        for (Parameter p : smhiClient.weatherWebservice.getTimeSeries().get(hour+1).getParameters()) {
            if (p.getName().equals("t")) {
                temperature = p.getValues().get(0);
            }
        }
        return temperature;
    }

    public Integer getHumidityByTime(int hour) {
        int humidity = 0;
        for (Parameter p : smhiClient.weatherWebservice.getTimeSeries().get(hour+1).getParameters()) {
            if (p.getName().equals("r")) {
                humidity = p.getValues().get(0);
            }
        }
        return humidity;
    }




}
