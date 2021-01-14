package com.findambrose.customerstoreapi.country;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;
    @PostMapping("/countries")
    public void createCountry (@RequestBody Country country){
        countryService.createCountry(country);
    }
    @GetMapping("/countries")
    public ArrayList<Country> getAllCountries(){
       return countryService.getAllCountries();
    }

    @GetMapping("/countries/{id}")
    public Country getOneCountry(@PathVariable String id){
        return countryService.getOneCountry(id);
    }

    @PutMapping("/countries/{id}")
    public void updateCountry (@RequestBody Country country){
        countryService.updateCountry(country);

    }

    @DeleteMapping("/countries/{id}")
    public void deleteCountry (@PathVariable String id){

        countryService.deleteCountry(id);
    }

}
