package com.bookshop.service;

import com.bookshop.entity.City;
import com.bookshop.entity.Country;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface CityService {

    boolean save(City city);

    List<City> findAll();

    City findOne(int id);

    void delete(int id);

    boolean update(City city);

    City findByName(String name);

    List<City> findAllSortedCities();

    List<City> findByCountry(Country country);
}
