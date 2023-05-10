package com.example.weatherwebservice;

import com.example.weatherwebservice.MET.MetWeatherWebservice;
import com.example.weatherwebservice.SMHI.SmhiWeatherWebservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class Runnable implements CommandLineRunner {
    WebClient client = WebClient.create();

    public SmhiWeatherWebservice getSmhi() {
        Mono<SmhiWeatherWebservice> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(SmhiWeatherWebservice.class);
        return mono.block();
    }

    public MetWeatherWebservice getMet() {
        Mono<MetWeatherWebservice> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(MetWeatherWebservice.class);
        return mono.block();
    }


    @Override
    public void run(String... args) throws Exception {
       // System.out.println(getSmhi().getTimeSeries());
        //System.out.println(getSmhi().getApprovedTime());
        //System.out.println(getSmhi().getTimeSeries().get(0).getParameters().get(10).getValues());


/*

        for (int i = 0; i < getSmhi().getTimeSeries().get(0).getParameters().size(); i++) {
            System.out.println(getSmhi().getTimeSeries().get(0).getParameters().get(i).getName());
            System.out.println(getSmhi().getTimeSeries().get(0).getParameters().get(i).getValues());
        }
        System.out.println(getSmhi().getTimeSeries());*/

        MetWeatherWebservice met = getMet();


            System.out.println(met.getProperties().getTimeseries().get(28).getData().getInstant().getDetails().getAirTemperature());



    }
}