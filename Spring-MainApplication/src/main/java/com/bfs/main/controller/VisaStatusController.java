package com.bfs.main.controller;

import com.bfs.main.domain.ApplicationWorkFlow;
import com.bfs.main.domain.VisaStatus;
import com.bfs.main.service.ApplicationWorkFlowService;
import com.bfs.main.service.StorageService;
import com.bfs.main.service.VisaStatusService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.util.List;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisaStatusController {

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

    @GetMapping("/visa")
    public List<VisaStatus> getVisaStatus(){
        return visaStatusService.getAllVisaStatus();
    }

    @GetMapping("/visa/id")
    public VisaStatus getVisaStatusById(@RequestParam("id") int id){
        VisaStatus visaStatus = visaStatusService.getVisaStatusById(id);
        return visaStatus;
    }

    @PostMapping("visa/update")
    public Integer updateVisa(@RequestParam("visa") VisaStatus visa){
        return visaStatusService.updateVisa(visa);
    }

    @GetMapping("/visa/status")
    public ApplicationWorkFlow getCurrentStatus(@RequestParam("id") int id){
        ApplicationWorkFlow applicationWorkFlow = applicationWorkFlowService.getCurrentStatus(id);
        return applicationWorkFlow;
    }




}
