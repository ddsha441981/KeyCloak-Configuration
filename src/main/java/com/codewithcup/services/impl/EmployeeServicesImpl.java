package com.codewithcup.services.impl;

import com.codewithcup.entity.Employee;
import com.codewithcup.repository.EmployeeRepository;
import com.codewithcup.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServicesImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostConstruct
    @Override
    public void saveEmployeDetails() {
        this.employeeRepository.saveAll(
                Stream.of(
                        new Employee("Employe 1","EMP10001",250000),
                        new Employee("Employe 2","EMP10002",220000),
                        new Employee("Employe 3","EMP10003",200000),
                        new Employee("Employe 4","EMP10004",280000),
                        new Employee("Employe 5","EMP10005",230000)
                ).collect(Collectors.toList()));
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return this.employeeRepository.findById(empId).orElse(null);
    }
}
