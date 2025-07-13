package com.cognizant.orm_learn;

import com.cognizant.orm_learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int departmentId = 1;
		double averageSalary = employeeService.getAverageSalary(departmentId);
		System.out.println("Average Salary in Department ID " + departmentId + ": " + averageSalary);
	}
}
