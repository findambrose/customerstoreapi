package com.findambrose.customerstoreapi.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/countries/{countryId}/stores/{storeId}/customers")
    public Customer save(@RequestBody Customer customer, @PathVariable String storeId){

        return customerService.save(customer, storeId);

    }

    @PutMapping("/countries/{countryId}/stores{storeId}/customers/{customerId}")
    public Customer update(@RequestBody Customer customer, @PathVariable String storeId){
       return customerService.update(customer, storeId);

    }

    @GetMapping("/countries/{countryId}/stores/{storeId}/customers")
    public ArrayList<Customer> get(@PathVariable String storeId){
        //Return an arraylist of customers in a store
       ArrayList<Customer> customers =  customerService.get(storeId);
        return customers;
    }

    @GetMapping("/countries/{countryId}/allstores/{storeId}")
    public Customer getOne(String id){
        //Return a customers by id
        Customer customer =  customerService.getOne(id);
        return customer;
    }


    @DeleteMapping("/countries/{countryId}/stores/{storeId}/customers/{customerId}")
    public String delete(@PathVariable String id){
        //Return an arraylist of customers in countries

        if (customerService.delete(id)){
            return "Success deleting";
        }

        return "Error deleting..";
    }
}
