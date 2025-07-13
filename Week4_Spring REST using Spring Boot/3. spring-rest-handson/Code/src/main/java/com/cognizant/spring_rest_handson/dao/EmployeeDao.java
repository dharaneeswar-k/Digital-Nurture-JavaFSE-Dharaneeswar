package com.cognizant.spring_rest_handson.dao;

import com.cognizant.spring_rest_handson.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {

    public static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao(@Value("classpath:employee.xml") Resource resource) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(resource.getURL().toString());
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
