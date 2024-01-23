/**
 * @author: Bek
 * Date: 1/18/2024
 * Time: 8:35 PM
 * Project Name: demo
 */

package com.example.demo.repository;


import com.example.demo.domain.Clouds;
import com.example.demo.domain.Wind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindRepository extends JpaRepository<Wind,Long> {

}
