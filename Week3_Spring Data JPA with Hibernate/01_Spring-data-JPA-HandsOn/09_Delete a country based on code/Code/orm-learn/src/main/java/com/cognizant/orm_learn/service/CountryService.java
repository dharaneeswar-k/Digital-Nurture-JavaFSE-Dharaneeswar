package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }


    @Transactional
    public void deleteCountry(String code) {
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
            System.out.println("Country with code " + code + " deleted.");
        } else {
            System.out.println("Country not found with code: " + code);
        }
    }
}
