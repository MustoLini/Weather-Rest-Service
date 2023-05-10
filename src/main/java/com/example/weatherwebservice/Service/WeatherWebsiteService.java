package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.DTO.MetDto;
import com.example.weatherwebservice.DTO.SmhiDto;
import com.example.weatherwebservice.DTO.WeatherWebsiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherWebsiteService {
    @Autowired
    MetDto metDto;
    @Autowired
    SmhiDto smhiDto;

    public WeatherWebsiteDto getTheBestWeather() {
        if (metDto.getTemperature() > smhiDto.getTemperature()) {
            return metDto;
        } else {
            return smhiDto;
        }
    }

    public String bestWeatherSource() {
        WeatherWebsiteDto weather = getTheBestWeather();
        if(weather.getClass().equals(SmhiDto.class)){
            return "SMHI";
        }
        else if(weather.getClass().equals(MetDto.class)){
            return "MET";
        }
        else{
            return "";
        }

    }
}
