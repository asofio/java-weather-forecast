package com.example.springtest.weather.Models;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalDate;

@Getter @Setter
public class WeatherForecast {
    
    public LocalDate Date;
    
    public int TemperatureC;
    
    @Getter 
    public int TemperatureF = 32 + (int)(TemperatureC / 0.5556);
    
    public String Summary;
    
    public WeatherForecast(LocalDate date, int temperatureC, String summary) {
        super();

        Date = date;
        TemperatureC = temperatureC;
        Summary = summary;
    }
}