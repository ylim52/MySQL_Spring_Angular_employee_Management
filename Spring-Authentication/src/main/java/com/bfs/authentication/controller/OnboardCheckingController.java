package com.bfs.authentication.controller;

import com.bfs.authentication.domain.ApplicationWorkFlow;
import com.bfs.authentication.domain.Employee;
import com.bfs.authentication.service.EmployeeService;
import com.bfs.authentication.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("onBoard")
public class OnboardCheckingController {

    private EmployeeService employeeService;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("check")
    public String checkOnBoard(HttpServletRequest httpServletRequest){
        Integer employeeId = Integer.valueOf(CookieUtil.getValue(httpServletRequest,"userID"));
        Employee currentEmployee = employeeService.getById(employeeId);
        ApplicationWorkFlow applicationWorkFlow = currentEmployee.getApplicationWorkFlow();
        String applicationType = applicationWorkFlow.getType();
        if (applicationType.equals("onboard")){
            String applicationState = applicationWorkFlow.getStatus();
            if (applicationState.equals("Active") || applicationState.equals("Rejected")){
                return "redirect:http://localhost:4200/#/onboard";
            }else{
                return "redirect:http://localhost:4200/#/pendingApplication";
            }
        }else{
            return "redirect:http://localhost:4200/#/user/home";
        }
    }


}
