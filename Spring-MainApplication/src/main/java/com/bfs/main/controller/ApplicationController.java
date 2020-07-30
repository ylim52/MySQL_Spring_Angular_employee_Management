package com.bfs.main.controller;

import com.bfs.main.domain.ApplicationWorkFlow;
import com.bfs.main.service.ApplicationWorkFlowService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationController {

    private ApplicationWorkFlowService applicationWorkFlowService;
    @Autowired
    public void setApplicationWorkFlowService(ApplicationWorkFlowService applicationWorkFlowService){
        this.applicationWorkFlowService = applicationWorkFlowService;
    }

    @GetMapping("getOnboard")
    public List<ApplicationWorkFlow> getAllApplications(){
        return applicationWorkFlowService.findByType("onboard");
    }

    @GetMapping("getId/{id}")
    public ApplicationWorkFlow getApplicationById(@PathVariable(name = "id")String id){
        Integer appId = Integer.parseInt(id);
        return applicationWorkFlowService.getCurrentStatus(appId);
    }

    @PostMapping("update")
    public void updateApplication(@RequestBody ApplicationWorkFlow applicationWorkFlow){
        applicationWorkFlowService.updateApplication(applicationWorkFlow);
    }
}
