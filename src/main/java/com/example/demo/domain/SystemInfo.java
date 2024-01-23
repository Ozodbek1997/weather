/**
 * @author: Bek
 * Date: 1/18/2024
 * Time: 7:35 PM
 * Project Name: demo
 */

package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@Entity
@Table(name = "Sys")
public class SystemInfo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private int type;

    @Column
    private long systemId; // 'id' from your data, renamed to avoid confusion with primary key

    @Column(length = 3) // Length based on country code standard (ISO 3166-1 alpha-2)
    private String country;

    @Column
    private Instant sunrise; // Using Instant for timestamp

    @Column
    private Instant sunset; // Using Instant for timestamp

}
