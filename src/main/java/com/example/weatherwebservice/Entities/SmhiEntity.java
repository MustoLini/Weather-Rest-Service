package com.example.weatherwebservice.Entities;

import com.example.weatherwebservice.ClientsManagment.SmhiClient;
import com.example.weatherwebservice.SMHI.Parameter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SmhiEntity extends WeatherWebsiteEntity {
    SmhiClient smhiClient;

    public SmhiEntity() {
        smhiClient = new SmhiClient();
        temperature = getNextDayTemperature();
        humidity = getNextDayHumidity();
        time = getNextDayTime();
    }

    Integer getNextDayTemperature() {
        int temperature = 0;
        for (Parameter p: smhiClient.weatherWebservice.getTimeSeries().get(25).getParameters()) {
            if(p.getName().equals("t")){
                temperature = p.getValues().get(0);
            }
        }
        return temperature;
    }

    Integer getNextDayHumidity() {
        int humidity = 0;
        for (Parameter p: smhiClient.weatherWebservice.getTimeSeries().get(25).getParameters()){
            if(p.getName().equals("r")){
                humidity = p.getValues().get(0);
            }
        }
        return humidity;
    }

    LocalDateTime getNextDayTime() {

        return LocalDateTime.parse(smhiClient.weatherWebservice.getTimeSeries().get(25).getValidTime(), DateTimeFormatter.ISO_DATE_TIME);
    }
}
