package com.findambrose.customerstoreapi.store;


import com.findambrose.customerstoreapi.country.Country;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ControllerTest {


    @InjectMocks
    StoreController storeController;
    @Mock
    StoreService storeService;

    @Test
    public void testGetAll(){
        //Check if store is returned by country.  Stub Service with Stores Arraylist

        //Given -- StoreId. Country Id
        Store store = new Store();
        Store store2 = new Store();
        store.setId("street");
        String countryId = "kenya";
        store.setCountry(new Country(countryId, "Kenya"));
        store2.setCountry(new Country(countryId, "Kenya"));
        store.setName("Street 5, Jumia");

        store2.setId("street");
        store2.setName("Street 5, Jumia");

        ArrayList<Store> stores = new ArrayList<>();

        stores.add(store);
        stores.add(store2);

        //When service.repo is hit::::  --Stub store arraylist
        when(storeService.getAll(countryId)).thenReturn(stores);
        //Action
        ArrayList<Store> storesFound =  storeController.getAll(countryId);
        //Assert
        assertThat(storesFound == stores);
//        storesFound.forEach((storeFound)->{
//            assertThat(storeFound.getCountry().getId() == "kenya");
//        });

    }

    @Test
    public void testGetOne(){

    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testUpdate(){

    }

    @Test
    public void testSave(){

    }
}
