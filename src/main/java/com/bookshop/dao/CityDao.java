package com.bookshop.dao;

import com.bookshop.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface CityDao extends JpaRepository<City, Integer> {

    City findByName(String name);

}
