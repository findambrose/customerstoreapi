package com.findambrose.customerstoreapi.customer;

import com.findambrose.customerstoreapi.store.Store;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String>, JpaSpecificationExecutor<Customer>{

}
