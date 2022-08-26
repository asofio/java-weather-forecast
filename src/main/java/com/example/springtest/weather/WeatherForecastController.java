package com.example.springtest.weather;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.weather.Models.WeatherForecast;

@RestController
public class WeatherForecastController {

    private static String[] Summaries = new String[] {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };
    
    @GetMapping("/weatherforecast")
    public Iterable<WeatherForecast> index() {

        var forecasts = new ArrayList<WeatherForecast>();

        for(var i = 0; i < 5; i++) {
            var rand = new Random();
            var forecast = new WeatherForecast(new LocalDate().plusDays(i), 
                                               rand.ints(1, -20, 55).findFirst().getAsInt(), 
                                               Summaries[rand.ints(1, 0, Summaries.length).findFirst().getAsInt()]);
            forecasts.add(forecast);
        }

        return forecasts;
    }

}
