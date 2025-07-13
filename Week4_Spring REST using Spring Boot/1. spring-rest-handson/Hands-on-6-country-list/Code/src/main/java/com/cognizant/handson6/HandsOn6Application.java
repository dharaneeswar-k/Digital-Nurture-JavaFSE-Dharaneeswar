package com.cognizant.handson6;

import com.cognizant.handson6.model.Country;
import com.cognizant.handson6.model.CountryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class HandsOn6Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn6Application.class);

    public static void main(String[] args) {
        LOGGER.info("main|START");

        SpringApplication.run(HandsOn6Application.class, args);
        displayCountries();

        LOGGER.info("main|END");
    }

    public static void displayCountries() {
        LOGGER.info("displayCountries|START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        CountryList countryList = context.getBean("countryList", CountryList.class);
        List<Country> countries = countryList.getCountryList();

        for (Country c : countries) {
            LOGGER.debug("Country: {}", c);
        }

        LOGGER.info("displayCountries|END");
    }
}
