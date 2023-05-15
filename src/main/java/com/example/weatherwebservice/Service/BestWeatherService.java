package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherApiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import com.example.weatherwebservice.WeatherApi.WeatherAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class BestWeatherService {

    MetEntity metEntity;

    public BestWeatherService(MetEntity metEntity, SmhiEntity smhiEntity, WeatherApiEntity weatherApiEntity) {
        this.metEntity = metEntity;
        this.smhiEntity = smhiEntity;
        this.weatherApiEntity = weatherApiEntity;
    }

    SmhiEntity smhiEntity;

    WeatherApiEntity weatherApiEntity;



    String bestWeatherSource;

    public WeatherWebsiteEntity getTheBestWeather() {
        System.out.println("Smhi temp: "+smhiEntity.getTemperature());
        System.out.println("Smhi tid: "+smhiEntity.getTime());
        System.out.println("MET temp: "+metEntity.getTemperature());
        System.out.println("MET tid: "+metEntity.getTime());
        System.out.println("WeatherAPI temp: "+weatherApiEntity.getTemperature());
        System.out.println("WeatherAPI time: "+weatherApiEntity.getTime());
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
