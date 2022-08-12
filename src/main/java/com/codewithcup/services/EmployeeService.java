package com.codewithcup.services;

import com.codewithcup.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //save
    public void saveEmployeDetails();
    //get all employee
    public List<Employee> getEmployees();
    //get by id
    public Employee getEmployeeById(int empId);
}
