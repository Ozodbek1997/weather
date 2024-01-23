/**
 * @author: Bek
 * Date: 1/18/2024
 * Time: 7:56 PM
 * Project Name: demo
 */

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {



    private String base;
    private int timezone;
    private String name;
    private long dt;
    private int cod;
    private int visibility;
    private long id;

    private Coord coord;

    private Clouds clouds;

    private Main main;

    private SystemInfo sys;

    private List<Weather> weather;


    private Wind wind;

}
