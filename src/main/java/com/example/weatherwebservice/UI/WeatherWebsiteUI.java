package com.example.weatherwebservice.UI;

import com.example.weatherwebservice.Service.BestWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherWebsiteUI {
    @Autowired
    BestWeatherService bestWeatherService;


    @GetMapping("/weather")
    public String weather(Model m){
        m.addAttribute("bestWeather", bestWeatherService.getTheBestWeather());
        m.addAttribute("source", bestWeatherService.bestWeatherSource());
        return "weatherPage";
    }


}
