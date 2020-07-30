package com.bfs.main.controller;

import com.bfs.main.commonFunction.generateToken;
import com.bfs.main.commonFunction.getTime;
import com.bfs.main.domain.*;
import com.bfs.main.service.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HirePageController {

    private ApplicationWorkFlowService applicationWorkFlowService;
    private RegistrationTokenService registrationTokenService;

    @Autowired
    public void setApplicationWorkFlowService(ApplicationWorkFlowService applicationWorkFlowService){
        this.applicationWorkFlowService = applicationWorkFlowService;
    }

    @Autowired
    public void setRegistrationTokenService(RegistrationTokenService registrationTokenService){
        this.registrationTokenService = registrationTokenService;
    }

    @GetMapping("/hire")
    public List<ApplicationWorkFlow> getAllApplication(){
        return applicationWorkFlowService.getAllApplications();
    }

    @PostMapping("/token/new")
    public void generateToken(@RequestBody RegistrationToken token){
        token.setToken(generateToken.getRandomString(10));
        token.setValidDuration(getTime.getExpirationTime(180));
        this.registrationTokenService.addToken(token);

    }

    @GetMapping("/token")
    public List<RegistrationToken> getAllTokens(){ return registrationTokenService.getAll();}

    @Autowired
    ContactService contactService;
}
