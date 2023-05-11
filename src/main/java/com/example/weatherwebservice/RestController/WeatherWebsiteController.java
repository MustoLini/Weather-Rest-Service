package com.example.weatherwebservice.RestController;

import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import com.example.weatherwebservice.Service.WeatherWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherWebsiteController {

    @Autowired
    WeatherWebsiteService weatherWebsiteService;

    @GetMapping("/rs/weather")
    public ResponseEntity<WeatherWebsiteEntity> getBestWeather(){
        return ResponseEntity.ok().body(weatherWebsiteService.getTheBestWeather());
    }




}
