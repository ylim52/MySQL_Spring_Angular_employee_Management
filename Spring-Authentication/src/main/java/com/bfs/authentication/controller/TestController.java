package com.bfs.authentication.controller;

import com.bfs.authentication.domain.Contact;
import com.bfs.authentication.domain.Employee;
import com.bfs.authentication.domain.User;
import com.bfs.authentication.service.ContactService;
import com.bfs.authentication.service.EmployeeService;
import com.bfs.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired EmployeeService employeeService;
    @Autowired UserService userService;
    @Autowired ContactService contactService;

    @GetMapping("test")
    @ResponseBody
    public Employee test(){
        List<Employee> e = employeeService.getAll();
        return e.get(e.size()-1);
    }

    @GetMapping("test2")
    @ResponseBody
    public User test2(){
        List<User> u = userService.getAll();
        return u.get(u.size()-1);
    }


    @GetMapping("test3")
    @ResponseBody
    public Contact test3(){
        List<Contact> c = contactService.getAll();
        return c.get(c.size()-1);
    }

    @GetMapping("input")
    @ResponseBody
    public String input(){
        employeeService.addNewEmployee();
        contactService.addNewContact();
        return "finished";
    }

}
