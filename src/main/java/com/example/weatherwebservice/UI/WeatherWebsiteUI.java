package com.example.weatherwebservice.UI;

import com.example.weatherwebservice.Controller.WeatherWebsiteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherWebsiteUI {
    @Autowired
    WeatherWebsiteController weatherWebsiteController;


    @GetMapping("/weather")
    public String weather(Model m){
        m.addAttribute("bestWeather",weatherWebsiteController.getTheBestWeather());
        m.addAttribute("source",weatherWebsiteController.bestWeatherSource());
        return "weatherPage";
    }


}
