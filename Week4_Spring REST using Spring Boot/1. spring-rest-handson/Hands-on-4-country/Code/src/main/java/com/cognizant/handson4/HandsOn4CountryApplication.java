package com.cognizant.handson4;

import com.cognizant.handson4.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HandsOn4CountryApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(HandsOn4CountryApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START");

		SpringApplication.run(HandsOn4CountryApplication.class, args);
		displayCountry();

		LOGGER.info("END");
	}

	public static void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);

		LOGGER.debug("Country: {}", country);

		LOGGER.info("END");
	}
}
