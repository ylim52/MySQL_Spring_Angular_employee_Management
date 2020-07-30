package com.bfs.main.controller;

import com.bfs.main.domain.Employee;
import com.bfs.main.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HRHomepageController {

    private EmployeeService employeeService;

    @Autowired
    private void setEmployeeService(EmployeeService employeeService){ this.employeeService = employeeService; }

    @GetMapping("/home")
    public List<Employee> getEmployeeStatus(){
        return employeeService.getEmployee();
    }

}
