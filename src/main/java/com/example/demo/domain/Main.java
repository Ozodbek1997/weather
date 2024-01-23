/**
 * @author: Bek
 * Date: 1/18/2024
 * Time: 7:35 PM
 * Project Name: demo
 */

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Entity
public class Main {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private double temp;

//    @Column(name = "feels_like", precision = 4)
    private double feels_like;

//    @Column(name = "temp_min", precision = 5)
    private double temp_min;

/*    @Column(name = "temp_max", precision = 5)*/
    private double temp_max;

    private int pressure;


    private int humidity;
    private int sea_level;
    private int grnd_level;

}
