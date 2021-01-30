package com.findambrose.customerstoreapi.country;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepoTest {


    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CountryRepository countryRepository; //the test component  //depends on db

    @Test
    public void testSave(){

        //given
        Country country = new Country("kenya", "Kenya");
        //persist
        entityManager.persist(country);
        //action
        countryRepository.save(country);
        //assert
        assertEquals(countryRepository.findById("kenya").get(), country);

    }

    @Test
    public void testGetOne(){

        //given
        Country country = new Country("kenya", "Kenya");
        //persist
        entityManager.persist(country);
        //action
        Country result = countryRepository.findById("kenya").get();
        //assert

        assertEquals(result, country);

    }

    @Test
    public void getAll(){
        //given
        Country country = new Country("kenya", "Kenya");
        //given
        Country country2 = new Country("ug", "Uganda");
        entityManager.persist(country);
        entityManager.persist(country2);

        //action
        countryRepository.findAll().forEach(value->{
            if (value.getId() == "kenya"){
                assertEquals(value, country);
            }

            if (value.getId() == "uganda"){
                assertEquals(value, country2);
            }
        });



    }










}
