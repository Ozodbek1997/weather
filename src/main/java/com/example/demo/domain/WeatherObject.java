/**
 * @author: Bek
 * Date: 1/21/2024
 * Time: 2:31 PM
 * Project Name: demo
 */

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class WeatherObject {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String base;
    private int timezone;
    private String name;
    private long dt;
    private int cod;
    private int visibility;
    private long weatherId;
}
