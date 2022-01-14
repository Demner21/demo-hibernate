package com.dmnr.example.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipcode;
    private String city;
    private String nameAddress;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", nameAddress=" + nameAddress + ", zipcode=" + zipcode + "]";
    }
    
    

}
