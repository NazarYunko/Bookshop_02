package com.bookshop.controller;

import com.bookshop.entity.City;
import com.bookshop.service.CityService;
import com.bookshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Nazar on 05.06.2017.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/addcity")
    public String addCity(Model model) {
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return "views-city-addCity";
    }

    @PostMapping("/addcity")
    public String addCity(@RequestParam String cityName,
                          @RequestParam int countryId,
                          Model model) {
        cityService.save(new City(cityName, countryService.findOne(countryId)));
        return "redirect:/addcity";
    }

    @GetMapping("/deletecity/{id}")
    public String deleteCity(@PathVariable int id) {
        cityService.delete(id);
        return "redirect:/addcity";
    }

    @GetMapping("/updatecity/{id}")
    public String updateCity(@PathVariable int id, Model model) {
        model.addAttribute("currentCity", cityService.findOne(id));
        model.addAttribute("countries", countryService.findAll());
        return "views-city-updateCity";
    }

    @PostMapping("/updatecity/{id}")
    public String updateCity(@PathVariable int id,
                             @RequestParam String name,
                             @RequestParam int countryId,
                             Model model) {
        City city = cityService.findOne(id);
        city.setName(name);
        city.setCountry(countryService.findOne(countryId));
        cityService.update(city);
        return "redirect:/addcity";
    }

}
