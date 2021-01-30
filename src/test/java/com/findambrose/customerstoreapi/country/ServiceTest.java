package com.findambrose.customerstoreapi.country;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {


    @InjectMocks
    CountryService countryService;
    @Mock
    CountryRepository countryRepository;

//    CountryService countryService = new CountryService();
//
//    CountryRepository countryRepository = new CountryRepository();

    @Test
    public void testGetOne(){

        //given
        Country country = new Country();
        country.setId("kenya");
        country.setFullName("Kenya");

        //when
        when(countryRepository.findById("kenya")).thenReturn(java.util.Optional.of(country));
        Country found = countryService.getOneCountry("kenya");

       // assert

       assertEquals(found,country);



    }

    @Test

    public void testGetAll(){
        //given
        ArrayList<Country> countries = new ArrayList();
        countries.add(new Country("kenya", "Kenya"));
        countries.add(new Country("ug", "Uganda"));

        //when
        when(countryRepository.findAll()).thenReturn(countries);

        //action
        ArrayList<Country> found = countryService.getAllCountries();
        //assert
        assertEquals(found, countries);


    }



    @Test
    public void testDelete(){

        //given
        String id = "kenya";

        //when
        doNothing().when(countryRepository).deleteById(id);

        //action
        countryService.deleteCountry(id);

        //assert
        verify(countryRepository, times(1)).deleteById(id);
    }





}
