package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testAddCountry();
	}

	private static void testAddCountry() {
		Country country = new Country("XX", "Testland");
		countryService.addCountry(country);

		Country result = countryService.findCountryByCode("XX");
		if (result != null) {
			System.out.println("Country Added: " + result);
		} else {
			System.out.println("Country not found");
		}
	}
}
