package com.bookshop.service;

import com.bookshop.entity.Genre;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface GenreService {

    boolean save(Genre genre);

    List<Genre> findAll();

    Genre findOne(int id);

    void delete(int id);

    boolean update(Genre genre);

    Genre findByName(String name);

}
