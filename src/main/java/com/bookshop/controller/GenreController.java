package com.bookshop.controller;

import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.dto.GenreDto;
import com.bookshop.entity.Genre;
import com.bookshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Study on 07.06.2017.
 */
@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public boolean save(@RequestBody Genre genre) {
        return genreService.save(genre);
    }

    @GetMapping
    public List<GenreDto> findAllGenres() {
        return DtoUtilMapper.getGenresDto(genreService.findAll());
    }

    @DeleteMapping
    public void deleteGenre(@RequestBody String genreId) {
        genreService.delete(Integer.parseInt(genreId));
    }

    @PutMapping
    public boolean updateGenre(@RequestBody Genre genre) {
        return genreService.update(genre);
    }

}
