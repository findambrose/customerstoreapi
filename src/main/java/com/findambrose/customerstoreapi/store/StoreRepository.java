package com.findambrose.customerstoreapi.store;


import com.findambrose.customerstoreapi.country.Country;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, String> {



    Iterable<Store> findAllByCountry(Country country);
}
