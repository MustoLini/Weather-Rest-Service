package com.example.weatherwebservice.UI;

import com.example.weatherwebservice.Service.WeatherWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherWebsiteUI {
    @Autowired
    WeatherWebsiteService weatherWebsiteService;


    @GetMapping("/weather")
    public String weather(Model m){
        m.addAttribute("bestWeather", weatherWebsiteService.getTheBestWeather());
        m.addAttribute("source", weatherWebsiteService.bestWeatherSource());
        return "weatherPage";
    }


}
