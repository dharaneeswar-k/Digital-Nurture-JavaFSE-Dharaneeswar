package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.*;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) {
		testGetAllPermanentEmployees();
	}

	public void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();

		for (Employee e : employees) {
			LOGGER.debug("Employee: {}", e.getName());
			if (e.getDepartment() != null) {
				LOGGER.debug("Department: {}", e.getDepartment().getName());
			} else {
				LOGGER.debug("Department: null");
			}
			LOGGER.debug("Skills: {}", e.getSkillList());
		}

		LOGGER.info("End");
	}
}
