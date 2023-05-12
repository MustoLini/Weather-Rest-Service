package com.example.weatherwebservice.Service;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import com.example.weatherwebservice.Entities.WeatherWebsiteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class BestWeatherServiceTest {
    MetEntity metEntity = mock(MetEntity.class);
    SmhiEntity smhiEntity = mock(SmhiEntity.class);


    @Test
    void testBestWeather(){

        when(metEntity.getTemperature()).thenReturn(15);
        when(smhiEntity.getTemperature()).thenReturn(20);
        BestWeatherService bestWeatherService = new BestWeatherService(metEntity,smhiEntity);
        WeatherWebsiteEntity weather = bestWeatherService.getTheBestWeather();
        assertEquals(20,weather.getTemperature());

    }



}