package com.findambrose.customerstoreapi.country;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

//    @Autowired
//    TestEntityManager testEntityManager;
   @InjectMocks
   CountryController countryController;
   @Mock
   CountryService countryService;
   @Before
   public  void init (){

   }

    @Test
    public void testGetOneCountry(){


    //Goal is to see if the id from country found is equal to the one used to query

        //1. Mock/ fake values to database for testing
        Country country = new Country();
        country.setId("kenya");


        when(countryService.getOneCountry("kenya")).thenReturn(country);

       //.. testEntityManager.persist(country);

        //2. Get country whose id is kenya
       //.. country = countryController.getOneCountry("kenya");
        country = countryController.getOneCountry("kenya");

        //3. Check if country's id is same as kenya
        assertEquals(country.getId(), "kenya");

    }

}
