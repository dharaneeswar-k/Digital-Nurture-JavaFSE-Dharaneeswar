package com.cognizant.handson6.model;

import java.util.List;

public class CountryList {

    private List<Country> countryList;

    public CountryList() {
        System.out.println("CountryList Constructor Called");
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public String toString() {
        return "CountryList [countryList=" + countryList + "]";
    }
}
