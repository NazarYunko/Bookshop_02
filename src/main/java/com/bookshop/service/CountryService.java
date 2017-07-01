package com.bookshop.service;

import com.bookshop.entity.Country;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface CountryService {

    boolean save(Country country);

    List<Country> findAll();

    Country findOne(int id);

    void delete(int id);

    boolean update(Country country);

    Country findByName(String name);

    Country findCountryWithCities(int id);

}
