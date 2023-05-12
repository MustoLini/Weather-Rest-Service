package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestWeatherService {

    MetEntity metEntity;

    public BestWeatherService(MetEntity metEntity, SmhiEntity smhiEntity) {
        this.metEntity = metEntity;
        this.smhiEntity = smhiEntity;
    }

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
