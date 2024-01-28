/**
 * @author: Bek
 * Date: 1/17/2024
 * Time: 8:38 PM
 * Project Name: weather
 */

package com.example.demo.service;


import com.example.demo.domain.WeatherData;
import com.example.demo.domain.WeatherObject;
import com.example.demo.repository.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private final WindRepository windRepository;
    private final CloudsRepository cloudsRepository;
    private final CoordRepository coordRepository;
    private final MainRepository mainRepository;
    private final SystemInfoRepository systemInfoRepository;
    private final WeatherRepository weatherRepository;
    private final WeatherObjectRepository weatherObjectRepository;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;


    public String getWeather(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);

    }

    public void save(String jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            WeatherData weatherData = mapper.readValue(jsonData, WeatherData.class);
            windRepository.save(weatherData.getWind());
            cloudsRepository.save(weatherData.getClouds());
            mainRepository.save(weatherData.getMain());
            systemInfoRepository.save(weatherData.getSys());
            weatherRepository.save(weatherData.getWeather().get(0));
            coordRepository.save(weatherData.getCoord());
            saveWeatherObject(weatherData);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherObject(WeatherData weatherData) {
      WeatherObject weatherObject =   WeatherObject.builder()
                .weatherId(weatherData.getId())
                .base(weatherData.getBase())
                .timezone(weatherData.getTimezone())
                .name(weatherData.getName())
                .dt(weatherData.getDt())
                .cod(weatherData.getCod())
                .visibility(weatherData.getVisibility()).build();

      weatherObjectRepository.save(weatherObject);
    }


    public Mono<String> callWeatherApi() {
        String url = "http://localhost:8080/api/v1/weather?city=Seoul";
        WebClient webClient = WebClient.builder().build();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }


}
