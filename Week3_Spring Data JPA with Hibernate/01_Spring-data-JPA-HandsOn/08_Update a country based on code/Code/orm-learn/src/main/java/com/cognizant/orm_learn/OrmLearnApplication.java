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
		testUpdateCountry();
	}

	private static void testAddCountry() {
		Country country = new Country("XX", "Testland");
		countryService.addCountry(country);

		Country result = countryService.findCountryByCode("XX");
		System.out.println("Country Added: " + result);
	}

	private static void testUpdateCountry() {
		String code = "RS";
		String newName = "Russia";
		countryService.updateCountry(code, newName);

		Country updatedCountry = countryService.findCountryByCode(code);
		System.out.println("Updated Country: " + updatedCountry);
	}
}

