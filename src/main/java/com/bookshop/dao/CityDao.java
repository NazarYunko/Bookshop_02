package com.bookshop.dao;

import com.bookshop.entity.City;
import com.bookshop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface CityDao extends JpaRepository<City, Integer> {

    City findByName(String name);

    City findByNameAndCountry(String name, Country country);

    City findByIdAndNameAndCountry(int id, String name, Country country);

    @Query("select c from City c order by c.country.name")
    List<City> findAllSortedCities();

    @Query("select distinct c from City c where c.country=:country")
    List<City> findByCountry(@Param("country") Country country);
}
