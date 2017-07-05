package com.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Nazar on 04.06.2017.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage() {
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
}
