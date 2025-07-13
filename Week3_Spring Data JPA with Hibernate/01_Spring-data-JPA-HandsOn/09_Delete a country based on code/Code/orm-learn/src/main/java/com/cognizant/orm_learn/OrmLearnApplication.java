package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		//testAddCountry();
		testDeleteCountry();
	}

	private static void testAddCountry() {
		System.out.println("=== Add Country ===");
		Country country = new Country("ZZ", "Deleteland");
		countryService.addCountry(country);
		System.out.println("Added: " + countryService.findCountryByCode("ZZ"));
	}

	private static void testDeleteCountry() {
		System.out.println("=== Delete Country ===");
		countryService.deleteCountry("ZZ");
		Country deleted = countryService.findCountryByCode("ZZ");
		if (deleted == null) {
			System.out.println("Country successfully deleted.");
		} else {
			System.out.println("Still exists: " + deleted);
		}
	}
}

