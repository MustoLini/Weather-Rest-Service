package com.example.weatherwebservice.DTO;

import com.example.weatherwebservice.Client.SmhiClient;

public class SmhiDTO extends WeatherWebsiteDTO {
    SmhiClient smhiClient;

    public SmhiDTO() {
        smhiClient = new SmhiClient();
        temperature = getNextDayTemperature();
        humidity = getNextDayHumidity();
        time = getNextDayTime();
    }

    Integer getNextDayTemperature() {
        return smhiClient.weatherWebservice.getTimeSeries().get(25).getParameters().get(10).getValues().get(0);
    }

    Integer getNextDayHumidity() {
        return smhiClient.weatherWebservice.getTimeSeries().get(25).getParameters().get(15).getValues().get(0);
    }

    String getNextDayTime() {
        return smhiClient.weatherWebservice.getTimeSeries().get(25).getValidTime();
    }
}
