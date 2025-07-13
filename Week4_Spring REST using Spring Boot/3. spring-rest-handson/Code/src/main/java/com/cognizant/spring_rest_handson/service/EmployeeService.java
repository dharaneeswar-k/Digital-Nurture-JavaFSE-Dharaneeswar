package com.cognizant.spring_rest_handson.service;

import com.cognizant.spring_rest_handson.dao.EmployeeDao;
import com.cognizant.spring_rest_handson.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
