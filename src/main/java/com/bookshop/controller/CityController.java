package com.bookshop.controller;

import com.bookshop.dto.CityDto;
import com.bookshop.dto.DtoUtilMapper;
import com.bookshop.entity.City;
import com.bookshop.service.CityService;
import com.bookshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nazar on 05.06.2017.
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/city")
    public List<CityDto> findAllCities() {
        return DtoUtilMapper.getCitiesDto(cityService.findAllSortedCities());
    }

    @PostMapping("/findByCountry")
    public List<CityDto> findByCountry(@RequestBody String countryId) {
        return DtoUtilMapper.getCitiesDto(cityService.findByCountry(countryService.findOne(Integer.parseInt(countryId))));
    }

    @PostMapping("/city")
    public boolean saveCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping("/city")
    public boolean updateCity(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping("/city")
    public String deleteCity(@RequestBody String cityId) {
        cityService.delete(Integer.parseInt(cityId));
        return "200";
    }

}
