package com.findambrose.customerstoreapi.country;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {

//    @Autowired
//    TestEntityManager testEntityManager;
   @InjectMocks
   CountryController countryController;
   @Mock
   CountryService countryService;
    @Test
    public void testGetOneCountry(){


    //Goal is to see if the id from country found is equal to the one used to query

        //1. Mock/ fake values to database for testing
        Country country = new Country();
        country.setId("kenya");


        when(countryService.getOneCountry("kenya")).thenReturn(country);

        Country countryFound = countryController.getOneCountry("kenya");

        //3. Check if country's id is same as kenya
        assertEquals(countryFound.getId(), "kenya");

    }


    @Test
    public void testGetAllCountries(){

        ArrayList<Country> arrayList = new ArrayList<>();
        arrayList.add(new Country("kenya", "Kenya"));
        arrayList.add(new Country("cote", "Cote D'vore"));



        when(countryService.getAllCountries()).thenReturn(arrayList);
        verify(countryService).getAllCountries();
        ArrayList<Country> found = countryController.getAllCountries();
        assertEquals(found, arrayList);



    }

    @Test
    public void testSaveUpdate(){

        //given
        Country requestBody = new Country("kenya", "Kenya");

        //when
        when(countryService.createCountry(requestBody)).thenReturn(requestBody);

        //act
        Country savedCountry = countryController.createCountry(requestBody);
        //assert
        assertEquals(savedCountry, requestBody);


    }

    @Test
    public void testDelete(){

        //given
        String id = "kenya";


        //when
        doNothing().when(countryService).deleteCountry(id);


        //act
        countryController.deleteCountry(id);
        //assert
        verify(countryService, times(1)).deleteCountry(id);



    }


}
