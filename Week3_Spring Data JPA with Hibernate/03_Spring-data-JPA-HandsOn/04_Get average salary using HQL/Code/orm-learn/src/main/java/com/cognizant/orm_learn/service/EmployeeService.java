package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public double getAverageSalary(int deptId) {
        return employeeRepository.getAverageSalary(deptId);
    }
}
