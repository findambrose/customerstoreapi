package com.findambrose.customerstoreapi.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public CountryService(){}

    public ArrayList<Country> getAllCountries (){
        ArrayList<Country> countries = new ArrayList();

        countryRepository.findAll().forEach(country -> {
            countries.add(country);
        });
        return countries;
    }

    public Country getOneCountry (String id){

          return countryRepository.findById(id).get();

    }

    public void createCountry (Country country){
        countryRepository.save(country);
    }

    public void updateCountry (Country country){
        countryRepository.save(country);
    }

    public void deleteCountry (String id){

        countryRepository.delete(countryRepository.findById(id).get());

    }


}
