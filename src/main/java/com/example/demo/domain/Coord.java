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
public class Coord {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(precision = 10 )
    private double lon;

    @Column(precision = 10 )
    private double lat;

}
