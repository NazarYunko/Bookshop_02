package com.bookshop.controller;

import com.bookshop.dto.CountryDto;
import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.entity.Country;
import com.bookshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Qualifier;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public boolean addCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @GetMapping
    public List<CountryDto> findAllCountries() {
        return DtoUtilMapper.getCountriesDto(countryService.findAll());
    }

    @DeleteMapping
    public void deleteCountry(@RequestBody String cityId) {
        countryService.delete(Integer.parseInt(cityId));
    }

    @PutMapping
    public boolean updateCountry(@RequestBody Country country) {
        return countryService.update(country);
    }

}
