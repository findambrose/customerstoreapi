package com.findambrose.customerstoreapi.store;

import com.findambrose.customerstoreapi.country.Country;
import com.findambrose.customerstoreapi.customer.Customer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Store {

@Id
  private String id;
  private String name;

  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  Country country;

  @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "stores")
  Set<Customer> customers = new HashSet<>();

    public Store(){}

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public Country getCountry(){
        return country;
    }

    public void setCountry(Country country){
        this.country = country;
    }



    public String getName(){
        return name;
    }



}
