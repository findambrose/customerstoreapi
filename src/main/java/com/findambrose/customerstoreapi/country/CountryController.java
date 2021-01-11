package com.findambrose.customerstoreapi.country;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    public String getAllCountries(){
        return "All Countries";
    }

    @GetMapping("/countries/{id}")
    public String getOneCountry(@PathVariable String id){
        return id;
    }
    @PostMapping("/countries")
    public String createCountry (@RequestBody Country country){
        return "Countries created" + country.getFullName();
    }

    @PutMapping("/countries/{id}")
    public String updateCountry (@RequestBody Country country){
        return "Country updated" + country.getFullName();
    }

    @DeleteMapping("/countries/{id}")
    public String deleteCountry (@PathVariable Country country){
        return "Country deleted" + country.getFullName();
    }

}
