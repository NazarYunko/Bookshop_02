package com.bookshop.controller;

import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Nazar on 04.06.2017.
 */
@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("books", DtoUtilMapper.getNotFullBooksDto(bookService.findAll()));
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
    public String searchGet(){
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model) {
        if (bookService.findBookByName(search) != null) {
            model.addAttribute("book", DtoUtilMapper.getNotFullBookDto(bookService.findBookByName(search)));
            return "views-base-searchPage";
        } else {
            return "views-base-searchNotFound";
        }
    }
}
