package com.example.weatherwebservice.RestController;

import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import com.example.weatherwebservice.Service.BestWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherWebsiteController {

    @Autowired
    BestWeatherService bestWeatherService;

    @GetMapping("/rs/weather/{hour}")
    public ResponseEntity<WeatherWebsiteEntity> getBestWeather(@PathVariable int hour){
        return ResponseEntity.ok().body(bestWeatherService.getTheBestWeather(hour));
    }




}
