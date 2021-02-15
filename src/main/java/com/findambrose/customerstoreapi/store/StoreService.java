package com.findambrose.customerstoreapi.store;


import com.findambrose.customerstoreapi.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;
    ArrayList<Store> stores = new ArrayList<>();

    public void save (Store store){
        storeRepository.save(store);
    }

    public void update(Store store){
        storeRepository.save(store);
    }

    public ArrayList<Store> getAll(String countryId){

        //get all stores in a country
        Country country = new Country(countryId, "");
        Iterable<Store> iterable = storeRepository.findAllByCountry(country);
        iterable.forEach(store -> stores.add(store));
        return stores;
    }

    public Store getOne(String storeId){

        return  storeRepository.findById(storeId).get();
    }


    public boolean delete(String storeId){

        Store store = storeRepository.findById(storeId).get();
        storeRepository.delete(store);
        boolean storeExists = storeRepository.existsById(storeId);
        return storeExists;


    }
}

