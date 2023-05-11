package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestWeatherService {
    @Autowired
    MetEntity metEntity;
    @Autowired
    SmhiEntity smhiEntity;

    String bestWeatherSource;

    public WeatherWebsiteEntity getTheBestWeather() {
        System.out.println(smhiEntity.getTemperature());
        System.out.println(metEntity.getTemperature());
        if (metEntity.getTemperature() > smhiEntity.getTemperature()) {
            bestWeatherSource = "Met";
            return metEntity;
        } else {
            bestWeatherSource = "Smhi";
            return smhiEntity;
        }
    }

    public String bestWeatherSource() {
        return bestWeatherSource;
    }
}
