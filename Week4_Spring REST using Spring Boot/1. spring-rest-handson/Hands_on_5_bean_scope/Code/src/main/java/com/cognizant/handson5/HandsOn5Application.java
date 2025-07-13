package com.cognizant.handson5;

import com.cognizant.handson5.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HandsOn5Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn5Application.class);

    public static void main(String[] args) {
        LOGGER.info("main|START");

        SpringApplication.run(HandsOn5Application.class, args);
        displayCountry();

        LOGGER.info("main|END");
    }

    public static void displayCountry() {
        LOGGER.info("displayCountry|START");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country1 = context.getBean("country", Country.class);
        Country country2 = context.getBean("country", Country.class);

        LOGGER.debug("country1: {}", country1);
        LOGGER.debug("country2: {}", country2);

        LOGGER.info("Same object? {}", country1 == country2 ? "YES (Singleton)" : "NO (Prototype)");

        LOGGER.info("displayCountry|END");
    }
}
