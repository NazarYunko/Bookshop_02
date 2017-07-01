package com.bookshop.dao;

import com.bookshop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface CountryDao extends JpaRepository<Country, Integer> {

    Country findByName(String name);

    Country findByIdAndName(int id, String name);

    @Query("select c from Country c left join fetch c.cities where c.id=:id")
    Country findCountryWithCities(@Param("id") int id);
}
