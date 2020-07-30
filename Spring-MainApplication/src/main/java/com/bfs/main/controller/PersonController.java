package com.bfs.main.controller;

import com.bfs.main.domain.*;
import com.bfs.main.service.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonController {

    private EmployeeService employeeService;

    private AddressService addressService;

    private ContactService contactService;

    private VisaStatusService visaStatusService;

    private ApplicationWorkFlowService applicationWorkFlowService;

    @Autowired
    private void setVisaStatusService(VisaStatusService visaStatusService){
        this.visaStatusService = visaStatusService;
    }

    @Autowired
    private void setApplicationWorkFlowService(ApplicationWorkFlowService applicationWorkFlowService){
        this.applicationWorkFlowService = applicationWorkFlowService;
    }

    @Autowired
    private void setEmployeeService(EmployeeService employeeService){ this.employeeService = employeeService; }

    @Autowired
    private void setAddressService(AddressService addressService){ this.addressService = addressService; }

    @Autowired
    private void setContactService(ContactService contactService){ this.contactService = contactService; }

    @GetMapping("/employee/id")
    public Employee getEmployeeById(@RequestParam("id") int id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        return this.employeeService.getEmployee();
    }

    @PostMapping("/employee/update-name")
    public Employee updateName(@RequestBody Employee employee){
        return employeeService.updateName(employee);
    }

    @PostMapping("/employee/update-address")
    public Employee updateAddress(@RequestBody Employee employee){
        return addressService.updateAddress(employee);
    }

    @PostMapping("/employee/update-employment")
    public Employee updateEmployment(@RequestBody Employee employee){
        return employeeService.updateEmployment(employee);
    }

    @PostMapping("/employee/update-document")
    public Employee updateDocument(@RequestBody Employee employee){
        return employeeService.updateDocument(employee);
    }

    @GetMapping("/contact/id")
    public Contact getContactById(@RequestParam("id") int id){
        Contact contact = contactService.getContactById(id);
        return contact;
    }

    @GetMapping("getEmployee/{id}")
    public Employee getEmployeeByPathId(@PathVariable(name = "id") String id){
        Integer employeeId = Integer.parseInt(id);
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("updateEmployee")
    public void updateEmployeeOnboard(@RequestBody Employee employee){
        employee.getApplicationWorkFlow().setStatus("Pending");;
        employeeService.updateOnboard(employee);
    }
}
