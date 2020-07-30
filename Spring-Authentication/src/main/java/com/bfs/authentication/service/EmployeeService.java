package com.bfs.authentication.service;

import com.bfs.authentication.dao.EmployeeDao;
import com.bfs.authentication.domain.Employee;
import com.bfs.authentication.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao){ this.employeeDao = employeeDao; }

    public void addNewEmployee(){
        this.employeeDao.addEmployee();
    }

    public void addEmployee(Employee employee) { this.employeeDao.addEmployee(employee);}

    public List<Employee> getAll(){
        return this.employeeDao.getAll();
    }

    public Employee getById(Integer id){
        return employeeDao.getById(id);
    }

    public Employee getLastKey(){
       return  employeeDao.getLastKey();
    }

    public void update(Employee employee){
        employeeDao.updateEmployee(employee);
    }

}
