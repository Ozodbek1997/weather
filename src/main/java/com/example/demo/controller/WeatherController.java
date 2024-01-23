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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WeatherController {

    private final WeatherService weatherService;


    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        String jsonData = weatherService.getWeather(city);
        weatherService.save(jsonData);
        return jsonData;
    }


}
