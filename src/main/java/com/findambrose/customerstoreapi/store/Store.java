package com.findambrose.customerstoreapi.store;

import com.findambrose.customerstoreapi.country.Country;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Store {

@Id
  private String id;
  private String name;

  @ManyToOne(cascade = CascadeType.PERSIST)
  Country country;

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
