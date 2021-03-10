package com.findambrose.customerstoreapi.customer;

import com.findambrose.customerstoreapi.store.Store;

import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {

    @Id
    String id;
    String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = ""))
    Set<Store> stores = new HashSet<>();


    Customer(String id, String name){
        this.id = id;
        this.name = name;
    }

    public void setStore(Store store){
        stores.add(store);
    }
}
