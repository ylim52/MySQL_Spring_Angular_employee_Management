package com.bfs.main.controller;

import com.bfs.main.domain.ApplicationWorkFlow;
import com.bfs.main.domain.Employee;
import com.bfs.main.domain.PersonalDocument;
import com.bfs.main.domain.VisaStatus;
import com.bfs.main.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/documentListener")
public class DocumentController {

    StorageService storageService;

    PersonalDocumentService personalDocumentService;

    EmployeeService employeeService;

    ApplicationWorkFlowService applicationWorkFlowService;

    @Autowired
    private void setStorageService(StorageService storageService){
        this.storageService = storageService;
    }

    @Autowired
    private void setPersonalDocumentService(PersonalDocumentService personalDocumentService){
        this.personalDocumentService = personalDocumentService;
    }

    @Autowired
    private void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @Autowired
    private void setApplicationWorkFlowService(ApplicationWorkFlowService applicationWorkFlowService){
        this.applicationWorkFlowService = applicationWorkFlowService;
    }


    @GetMapping("/person")
    public List<PersonalDocument> getPersonalDocuments(@RequestParam("id") String id){
        Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
        return personalDocumentService.getDocuments(employee);
    }

    @PostMapping("/uploadFile")
    public void handleFileUpload(@RequestParam("fileType") String fileType,
                                   @RequestParam("file") MultipartFile file,
                                   @RequestParam("id") String id){
        try{
            storageService.saveAvatar(fileType, file, Integer.parseInt(id));
        }catch (Exception e){
            System.out.println("Error uploading file");
            e.printStackTrace();
        }
    }

    @PostMapping("/upload")
    public PersonalDocument uploadFile(@RequestParam("fileType") String fileType,
                                       @RequestParam("file") MultipartFile file,
                                       @RequestParam("id") String id) {
        try {
            return storageService.save(fileType, file, Integer.parseInt(id));
        } catch (Exception e) {
            System.out.println("Error uploading file");
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/download-form")
    public ResponseEntity<InputStreamResource> downloadForm(@RequestParam("fileName") String fileName) throws IOException {
        return storageService.downloadForm(fileName);
    }

    @GetMapping("/download-user")
    public ResponseEntity<InputStreamResource> downloadUser(@RequestParam("filePath") String filePath) throws IOException {
        return storageService.downloadUser(filePath);
    }

    @PostMapping("/approve")
    public ApplicationWorkFlow approveUser(@RequestParam("id") String id){
        Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
        return applicationWorkFlowService.approveUser(employee);
    }

    @PostMapping("/reject")
    public ApplicationWorkFlow rejectUser(@RequestParam("id") String id){
        Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
        return applicationWorkFlowService.rejectUser(employee);
    }

}
