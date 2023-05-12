package com.example.weatherwebservice;

import com.example.weatherwebservice.Entities.MetEntity;
import com.example.weatherwebservice.Entities.SmhiEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherWebsiteEntityTest {
    SmhiEntity smhiEntity= new SmhiEntity();
    MetEntity metEntity= new MetEntity();

    @Test
    void checkingIfTimeIsModularInSmhi(){
        assertEquals(smhiEntity.getTime(2).getHour(), LocalDateTime.now().getHour()+1);
    }
    @Test
    void checkingIfTimeIsModularInMet(){
        assertEquals(metEntity.getTime(3).getHour(),LocalDateTime.now().getHour()+2);
    }

}
