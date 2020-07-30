package com.bfs.authentication.service;

import com.bfs.authentication.dao.ApplicationWorkFlowDao;
import com.bfs.authentication.domain.ApplicationWorkFlow;
import com.bfs.authentication.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicationWorkFlowService {

    private ApplicationWorkFlowDao applicationWorkFlowDao;

    @Autowired
    public void setApplicationWorkFlowDao(ApplicationWorkFlowDao applicationWorkFlowDao){
        this.applicationWorkFlowDao = applicationWorkFlowDao;
    }

    public void addApplication(ApplicationWorkFlow applicationWorkFlow){
        applicationWorkFlowDao.addApplication(applicationWorkFlow);
    }

    public List<ApplicationWorkFlow> getAllApplications(){
        return this.applicationWorkFlowDao.getAll();
    }

    public void updateApplication(ApplicationWorkFlow applicationWorkFlow){
        applicationWorkFlowDao.updateApplication(applicationWorkFlow);
    }

    public ApplicationWorkFlow getCurrentStatus(int id) {
        return applicationWorkFlowDao.getCurrentStatus(id);
    }

    public ApplicationWorkFlow getLastKey(){
        return  applicationWorkFlowDao.getLastKey();
    }
}
