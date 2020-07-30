package com.bfs.main.controller;

import com.bfs.main.domain.*;
import com.bfs.main.security.CookieUtil;
import com.bfs.main.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TestController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";

    @Autowired AddressService addressService;
    @Autowired ApplicationWorkFlowService applicationWorkFlowService;
    @Autowired ContactService contactService;
    @Autowired DigitalDocumentService digitalDocumentService;
    @Autowired EmployeeService employeeService;
    @Autowired FacilityReportService facilityReportService;
    @Autowired FacilityReportDetailService facilityReportDetailService;
    @Autowired FacilityService facilityService;
    @Autowired HouseService houseService;
    @Autowired PersonalDocumentService personalDocumentService;
    @Autowired RegistrationTokenService registrationTokenService;
    @Autowired RoleService roleService;
    @Autowired UserRoleService userRoleService;
    @Autowired UserService userService;
    @Autowired VisaStatusService visaStatusService;

    @GetMapping("test1")
    @ResponseBody
    public User test1(){
        return this.userService.getAll().get(0);
    }

    @GetMapping("test2")
    @ResponseBody
    public Role test2(){
        return this.roleService.getAll().get(0);
    }

    @GetMapping("test3")
    @ResponseBody
    public String test3(){
        List<UserRole> maps = this.userRoleService.getByUserId(1);
        String res = "";
        for (UserRole userRole: maps){
            res += " " + userRole.getRoles().getDescription();
        }
        return res;
    }

    @GetMapping("test4")
    @ResponseBody
    public String test4(HttpServletRequest httpServletRequest){
        String cookies = CookieUtil.getValue(httpServletRequest, "username");
        return cookies;
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        CookieUtil.clear(httpServletResponse, "userID");
        return "logout";
    }

}