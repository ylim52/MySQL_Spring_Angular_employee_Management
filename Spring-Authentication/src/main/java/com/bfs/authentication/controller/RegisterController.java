package com.bfs.authentication.controller;

import com.bfs.authentication.dao.RoleDao;
import com.bfs.authentication.domain.*;
import com.bfs.authentication.service.*;
import com.bfs.authentication.util.CookieUtil;
import com.bfs.authentication.util.JwtUtil;
import com.bfs.authentication.util.timeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {

    private TokenService tokenService;
    private EmployeeService employeeService;
    private UserService userService;
    private ContactService contactService;
    private RoleService roleService;
    private UserRoleService userRoleService;
    private ApplicationWorkFlowService applicationWorkFlowService;
    private VisaStatusService visaStatusService;
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    @Autowired
    public void setTokenService(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @Autowired
    public void setContactService(ContactService contactService){ this.contactService = contactService; }

    @Autowired
    public void setRoleService(RoleService roleService){this.roleService =  roleService;}

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setApplicationWorkFlowService(ApplicationWorkFlowService applicationWorkFlowService){
        this.applicationWorkFlowService=applicationWorkFlowService;
    }

    @Autowired
    public void setVisaStatusService(VisaStatusService visaStatusService){
        this.visaStatusService = visaStatusService;
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("register2")
    public String register2(String token, Model model, HttpServletRequest request){

        List<Token> tokens = this.tokenService.getByToken(token);
        if (tokens.isEmpty()){
            model.addAttribute("msg","Invalid token");
            return "register";
        }
        Token currentToken = tokens.get(0);
        String expirationTime = currentToken.getValidDuration();
        String currentTime = timeUtil.getCurrentTime();
        boolean expired = timeUtil.compareDate(currentTime,expirationTime);
        if (expired){
            model.addAttribute("msg","Token has expired");
            return "register";
        }
        HttpSession session = request.getSession();
        session.setAttribute("email",currentToken.getEmail());
        return "setup";
    }

    @PostMapping("setup")
    public String setUp(String username, String password1, String password2, Model model,
                        HttpServletRequest request, HttpServletResponse httpServletResponse){
        List<User> users;
        if (username.equals("")){
            model.addAttribute("msg","Please Enter Username");
            return "setup";
        }else if (password1.equals("") || password2 .equals("")){
            model.addAttribute("msg","Please Enter Password");
            return "setup";
        }else if (!password1.equals(password2)){
            model.addAttribute("msg","Passwords are inconsistent");
            return "setup";
        }
        users = this.userService.getByUsername(username);
        if(!users.isEmpty()){
            model.addAttribute("msg","Username has been taken");
            return "setup";
        }
        String email = (String) request.getSession().getAttribute("email");
        System.out.println(email);
        // create new user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password1);
        user.setEmail((String) request.getSession().getAttribute("email"));
        user.setCreateDate(timeUtil.getCurrentTime());
        user.setEmployee(employeeService.getLastKey());
        System.out.println("User set up");
        // Add a new contact
        contactService.addNewContact();
        System.out.println("add contact");
        // create new employee and house
        Employee employee = new Employee();
        System.out.println("create new employee");

        ApplicationWorkFlow applicationWorkFlow = new ApplicationWorkFlow();
        applicationWorkFlow.setType("onboard");
        applicationWorkFlow.setCreatedDate(timeUtil.getCurrentTime());
        applicationWorkFlow.setModificationDate(timeUtil.getCurrentTime());
        applicationWorkFlow.setStatus("Active");
        applicationWorkFlowService.addApplication(applicationWorkFlow);
        ApplicationWorkFlow newApplicationWorkFlow = applicationWorkFlowService.getLastKey();
        System.out.println("Application set up");

        Address address = new Address();
        address.setAddressLine1("default");
        System.out.println("Address set up");

        System.out.println("begin new visa");
        VisaStatus visaStatus = new VisaStatus();
        visaStatus.setActive(1);
        visaStatus.setVisaType("Null");
        System.out.println("end new visa");

        employee.setVisaStatus(visaStatus);
        employee.setAddress(address);
        employee.setApplicationWorkFlow(newApplicationWorkFlow);
        employee.setEmail(email);
        employee.getVisaStatus().setVisaType("F1");
        employee.setLicense("0");
        employeeService.addEmployee(employee);
        System.out.println("add new employee");

        // get the latest employee and connect to user
        user.setEmployee(employeeService.getLastKey());
        // add user to db
        userService.addUser(user);
        // get latest user
        User currentUser = userService.getLastKey();
        // create new UserRole connection and add to db\

        UserRole newConnection = new UserRole();
        Role role = roleService.getLast();
        newConnection.setActiveFlag(1);
        newConnection.setCreateDate(timeUtil.getCurrentTime());
        newConnection.setUserID(currentUser.getID());
        newConnection.setRoles(role);
        userRoleService.addUserRole(newConnection);
        //setup cookie based on user information
        String token = JwtUtil.generateToken(signingKey, username);
        String userToken = username;
        CookieUtil.create(httpServletResponse, jwtTokenCookieName,
                token, false, -1 , "localhost");
        CookieUtil.createFront(httpServletResponse, "userID",
                String.valueOf(currentUser.getEmployee().getId()), false, -1 , "localhost");
        CookieUtil.createFront(httpServletResponse, "role",
                "user", false, -1 , "localhost");
        CookieUtil.createFront(httpServletResponse, "username",
                currentUser.getUsername(), false, -1 , "localhost");

        return "redirect:http://localhost:4200/#/onboard";
    }
}
