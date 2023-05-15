package com.example.weatherwebservice;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherApiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherWebsiteEntityTest {
    SmhiEntity smhiEntity= new SmhiEntity();
    MetEntity metEntity= new MetEntity();
    WeatherApiEntity weatherApiEntity = new WeatherApiEntity();
    @Test
    void checkingIfTimeIsModularInSmhi(){
        assertEquals(smhiEntity.getTimeBySmhi(0).getHour(), LocalDateTime.now().getHour());
    }
    @Test
    void checkingIfTimeIsModularInMet(){
        System.out.println(metEntity.getTimeByMet(-1));
        assertEquals(metEntity.getTimeByMet(0).getHour(),LocalDateTime.now().getHour());
    }
    @Test
    void checkingIfTimeIsModularInWeatherApi(){
        assertEquals(weatherApiEntity.getTimeByWeatherApi(2).getHour(),LocalDateTime.now().getHour()+2);
    }

}
