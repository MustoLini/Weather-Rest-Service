package com.example.weatherwebservice.Controller;

import com.example.weatherwebservice.DTO.MetDto;
import com.example.weatherwebservice.DTO.SmhiDto;
import com.example.weatherwebservice.DTO.WeatherWebsiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class WeatherWebsiteController {
    @Autowired
    MetDto metDto;
    @Autowired
    SmhiDto smhiDto;

    WeatherWebsiteDto getTheBestWeather() {
        if (metDto.getTemperature() > smhiDto.getTemperature()) {
            return metDto;
        } else {
            return smhiDto;
        }
    }

}
