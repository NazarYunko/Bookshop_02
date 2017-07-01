package com.bookshop.service;

import com.bookshop.entity.City;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface CityService {

    void save(City city);

    List<City> findAll();

    City findOne(int id);

    void delete(int id);

    void update(City city);

    City findByName(String name);

}
