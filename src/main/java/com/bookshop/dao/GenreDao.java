package com.bookshop.dao;

import com.bookshop.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface GenreDao extends JpaRepository<Genre, Integer> {

    Genre findByName(String name);

    Genre findByIdAndName(int id, String name);

}
