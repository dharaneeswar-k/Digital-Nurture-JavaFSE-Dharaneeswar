package com.cognizant.jwt_authentication_handson.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Map<String, String>> getCountries() {
        List<Map<String, String>> countries = new ArrayList<>();
        countries.add(Map.of("code", "IN", "name", "India"));
        countries.add(Map.of("code", "US", "name", "USA"));
        countries.add(Map.of("code", "JP", "name", "Japan"));
        return countries;
    }
}
