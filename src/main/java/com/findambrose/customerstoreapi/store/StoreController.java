package com.findambrose.customerstoreapi.store;


import com.findambrose.customerstoreapi.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StoreController {

    @Autowired
    StoreService storeService;


    @PostMapping("/countries/{countryId}/stores")
    public void save(@RequestBody Store store, @PathVariable String countryId){
        Country country = new Country();
        country.setFullName("Kenya");
        country.setId(countryId);
        store.setCountry(country);
        storeService.save(store);
    }

    @PutMapping("countries/{countryId/stores/{storeId}")
    public void update(@RequestBody Store store){
        storeService.update(store);
    }

    @GetMapping("countries/{countryId}/stores")
    public ArrayList<Store> getAll(@PathVariable String countryId){
        return storeService.getAll(countryId);
    }

    @GetMapping("countries/{countryId}/stores/{storeId}")
    public Store getOne(@PathVariable String storeId){
        return storeService.getOne(storeId);
    }

    @DeleteMapping("/countries/{countryId}/stores/{storeId}")
    public String delete(@PathVariable String storeId){
        if (storeService.delete(storeId)){
        return "Store successfully deleted";
        }
        return "Error deleting store";
    }
}
