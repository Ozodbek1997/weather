/**
 * @author: Bek
 * Date: 1/18/2024
 * Time: 7:09 PM
 * Project Name: weather
 */

package com.example.demo.controller;

import com.example.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WeatherController {

    private final WeatherService weatherService;


//http://localhost:8080/api/v1/weather?city=Seoul
    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        String jsonData = weatherService.getWeather(city);
        weatherService.save(jsonData);
        return jsonData;
    }

    @GetMapping("/callWeather")
    public  Mono<String>  callWeatherApi() {
        return weatherService.callWeatherApi();
    }




}
