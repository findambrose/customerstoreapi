package com.findambrose.customerstoreapi.customer;

import com.findambrose.customerstoreapi.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer, String storeId) {

        Store store = new Store();
        store.setId(storeId);
        customer.setStore(store);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer,  String storeId) {

         Store store = new Store();
          store.setId(storeId);
          customer.setStore(store);
          return customerRepository.save(customer);

    }

    public ArrayList<Customer> get(String id) {
        //Get all customers in a store
       ArrayList<Customer> customers = new ArrayList<>();

       Store store = new Store();
       store.setId(id);
       customerRepository.findAllByStore(store).forEach((customer)->{customers.add(customer);});
       return customers;
    }
    public Customer getOne(String id) {

        return  customerRepository.findById(id).get();
    }

    public boolean delete(String id) {
        customerRepository.deleteById(id);
        if (customerRepository.existsById(id)){
            return false;
        }
        return true;
    }
}
