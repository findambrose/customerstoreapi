package com.findambrose.customerstoreapi.customer;


import com.findambrose.customerstoreapi.store.Store;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Customer.class)
public class Customer_ {
    public static volatile SetAttribute<Customer, Store> stores;
}
