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
        time = getTimeBySmhi(hour);
        weatherSource = "SMHI";
    }


    public LocalDateTime getTimeBySmhi(int hour) {

        return LocalDateTime.parse(smhiClient.weatherWebservice.getTimeSeries().get(checkTimeIsTheSame() + hour).getValidTime(), DateTimeFormatter.ISO_DATE_TIME);
    }

    public Integer getTemperatureByTime(int hour) {
        int temperature = 0;
        for (Parameter p : smhiClient.weatherWebservice.getTimeSeries().get(checkTimeIsTheSame() + hour).getParameters()) {
            if (p.getName().equals("t")) {
                temperature = p.getValues().get(0);
            }
        }
        return temperature;
    }

    public Integer getHumidityByTime(int hour) {
        int humidity = 0;
        for (Parameter p : smhiClient.weatherWebservice.getTimeSeries().get(checkTimeIsTheSame() + hour).getParameters()) {
            if (p.getName().equals("r")) {
                humidity = p.getValues().get(0);
            }
        }
        return humidity;
    }

    private Integer checkTimeIsTheSame() {
        Boolean isItCorrect = false;
        int i = 0;
        LocalDateTime localDateTime = LocalDateTime.parse(smhiClient.weatherWebservice.getTimeSeries().get(0).getValidTime(), DateTimeFormatter.ISO_DATE_TIME);
        while (isItCorrect == false) {
            if (localDateTime.getHour() + i != LocalDateTime.now().getHour()) {
                i++;
            } else {
                isItCorrect = true;
            }
        }
        return i;
    }


}
