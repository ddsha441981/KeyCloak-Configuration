package com.codewithcup.controller;

import com.codewithcup.entity.Employee;
import com.codewithcup.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/keycloak")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //this method can accessed by admin where role is admin
//    @GetMapping("/getall")
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> fetchAll(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    //this method can accessed by user where role is user
    @GetMapping("/{empId}")
    @RolesAllowed("user")
    public ResponseEntity<Employee> fetchById(@PathVariable int empId){
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }
}
