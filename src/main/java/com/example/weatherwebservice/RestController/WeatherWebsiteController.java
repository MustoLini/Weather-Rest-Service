package com.example.weatherwebservice.RestController;

import com.example.weatherwebservice.Service.WeatherWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherWebsiteController {

    @Autowired
    WeatherWebsiteService weatherWebsiteService;




}
