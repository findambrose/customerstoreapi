package com.findambrose.customerstoreapi.customer;

import com.findambrose.customerstoreapi.store.Store;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

    @Id
    String id;
    String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    Store store;
    Customer(String id, String name){
        this.id = id;
        this.name = name;
    }


    public void setStore(Store store){
        this.store = store;
    }
}
