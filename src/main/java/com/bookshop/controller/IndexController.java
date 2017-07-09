package com.bookshop.controller;

import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.entity.Book;
import com.bookshop.entity.Genre;
import com.bookshop.service.AuthorService;
import com.bookshop.service.BookService;
import com.bookshop.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/")
    public String homePage(Model model) {
       return "views-base-index";
    }

    @PostMapping("/")
    public String homePageAfterLogin() {
        return "views-base-index";
    }

    @GetMapping("/countries")
    public String countries() {
        return "views-country-country";
    }

    @GetMapping("/cities")
    public String cities() {
        return "views-city-city";
    }

    @GetMapping("/genres")
    public String genres() {
        return "views-genre-genre";
    }

    @GetMapping("/publishers")
    public String publisher() {
        return "views-publisher-publisher";
    }

    @GetMapping("/search")
    public String searchGet() {
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model) {
        List<Book> foundBooks = new ArrayList<>();

        Book book = bookService.findBookByName(search);
        if (book != null) {
            foundBooks.add(book);
        }

        List<Book> booksByGenre = bookService.findBooksByGenre(genreService.findByName(search));
        if (!booksByGenre.isEmpty()) {
            foundBooks.addAll(booksByGenre);
        }
        if (!foundBooks.isEmpty()) {
            model.addAttribute("books", DtoUtilMapper.getNotFullBooksDto(foundBooks));
            return "views-base-searchPage";
        } else {
            return "views-base-searchNotFound";
        }
    }
}
