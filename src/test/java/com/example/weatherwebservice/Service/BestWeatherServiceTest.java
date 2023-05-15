package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherApiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import com.example.weatherwebservice.WeatherApi.WeatherAPI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BestWeatherServiceTest {
    MetEntity metEntity = mock(MetEntity.class);
    SmhiEntity smhiEntity = mock(SmhiEntity.class);
    WeatherApiEntity weatherApiEntity = mock(WeatherApiEntity.class);


    @Test
    void testBestWeather(){

        when(metEntity.getTemperature()).thenReturn(15);
        when(smhiEntity.getTemperature()).thenReturn(20);
        when(weatherApiEntity.getTemperature()).thenReturn(2);
        BestWeatherService bestWeatherService = new BestWeatherService(metEntity,smhiEntity,weatherApiEntity);
        WeatherWebsiteEntity weather = bestWeatherService.getTheBestWeather(2);
        assertEquals(20,weather.getTemperature());

    }



}