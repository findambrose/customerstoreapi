package com.findambrose.customerstoreapi.country;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
   private String id;
   private String fullName;

    public Country(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Country(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
