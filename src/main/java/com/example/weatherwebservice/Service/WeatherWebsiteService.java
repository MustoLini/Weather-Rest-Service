package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Client.MetClient;
import com.example.weatherwebservice.Client.SmhiClient;
import com.example.weatherwebservice.DTO.MetDTO;
import com.example.weatherwebservice.DTO.SmhiDTO;
import com.example.weatherwebservice.DTO.WeatherWebsiteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherWebsiteService {
    @Autowired
    MetDTO metDTO;
    @Autowired
    SmhiDTO smhiDTO;

    public WeatherWebsiteDTO getTheBestWeather() {
        if (metDTO.getTemperature() > smhiDTO.getTemperature()) {
            return metDTO;
        } else {
            return smhiDTO;
        }
    }

    public String bestWeatherSource() {
        WeatherWebsiteDTO weather = getTheBestWeather();
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
