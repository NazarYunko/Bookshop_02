package com.bookshop.dao;

import com.bookshop.entity.Author;
import com.bookshop.entity.City;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface AuthorDao extends JpaRepository<Author, Integer>{

    Author findByNameAndLastNameAndCityAndDateOfBirth(String name, String lastName, City city, LocalDate dateOfBirth);

    @Query("select a from Author a left join fetch a.books where a.id=:id")
    Author findAuthorWithBooks(@Param("id") int id);
}
