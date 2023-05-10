package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Client.MetClient;
import com.example.weatherwebservice.Client.SmhiClient;
import com.example.weatherwebservice.Client.WeatherWebsiteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherWebsiteService {
    @Autowired
    MetClient metClient;
    @Autowired
    SmhiClient smhiClient;

    public WeatherWebsiteClient getTheBestWeather() {
        if (metClient.getTemperature() > smhiClient.getTemperature()) {
            return metClient;
        } else {
            return smhiClient;
        }
    }

    public String bestWeatherSource() {
        WeatherWebsiteClient weather = getTheBestWeather();
        if(weather.getClass().equals(SmhiClient.class)){
            return "SMHI";
        }
        else if(weather.getClass().equals(MetClient.class)){
            return "MET";
        }
        else{
            return "";
        }

    }
}
