package com.findambrose.customerstoreapi.country;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService {

    public CountryService(){}

    public String getAllCountries (){
        return "All Countries";
    }

    public Country getOneCountry (String id){
        return new Country("kenya", "Kenya");
    }
    public void createCountry (Country country){

    }

    public void updateCountry (Country country, String id){

    }

    public void deleteCountry (String id){

    }


}
