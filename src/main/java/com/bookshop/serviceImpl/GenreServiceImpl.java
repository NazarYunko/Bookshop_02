package com.bookshop.serviceImpl;

import com.bookshop.dao.GenreDao;
import com.bookshop.entity.Genre;
import com.bookshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public boolean save(Genre genre) {
        if (genreDao.findByName(genre.getName()) == null) {
            genreDao.save(genre);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public Genre findOne(int id) {
        return genreDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        genreDao.delete(id);
    }

    @Override
    public boolean update(Genre genre) {
        if (genreDao.findByIdAndName(genre.getId(), genre.getName()) != null) {
            genreDao.save(genre);
            return true;
        }
        if (genreDao.findByName(genre.getName()) == null) {
            genreDao.save(genre);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Genre findByName(String name) {
        return genreDao.findByName(name);
    }

}