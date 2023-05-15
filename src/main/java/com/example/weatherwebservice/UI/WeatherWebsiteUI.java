package com.example.weatherwebservice.UI;

import com.example.weatherwebservice.Service.BestWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherWebsiteUI {
    @Autowired
    BestWeatherService bestWeatherService;

    public WeatherWebsiteUI(BestWeatherService bestWeatherService) {
        this.bestWeatherService = bestWeatherService;
    }

    @PostMapping ("time")
    public String whatTimeYouWantToGetWeather(Model m, @RequestParam int hours){
        m.addAttribute("bestWeather",bestWeatherService.getTheBestWeather(hours));
        m.addAttribute("source",bestWeatherService.bestWeatherSource());
        return "weatherPage";
    }


}
