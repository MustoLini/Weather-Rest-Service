package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherApiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BestWeatherService {
    MetEntity metEntity;
    SmhiEntity smhiEntity;
    WeatherApiEntity weatherApiEntity;
    String bestWeatherSource;


    public BestWeatherService(MetEntity metEntity, SmhiEntity smhiEntity, WeatherApiEntity weatherApiEntity) {
        this.metEntity = metEntity;
        this.smhiEntity = smhiEntity;
        this.weatherApiEntity = weatherApiEntity;
    }

    public WeatherWebsiteEntity getTheBestWeather(int i) {
        weatherApiEntity.setHour(i);
        weatherApiEntity.updateInformation();
        metEntity.setHour(i);
        metEntity.updateInformation();
        smhiEntity.setHour(i);
        smhiEntity.updateInformation();
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
