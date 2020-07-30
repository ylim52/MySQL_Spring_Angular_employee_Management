package com.bfs.authentication.service;


import com.bfs.authentication.dao.VisaStatusDao;
import com.bfs.authentication.domain.VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VisaStatusService {

    private VisaStatusDao visaStatusDao;

    @Autowired
    public void setApplicationWorkFlowDao(VisaStatusDao visaStatusDao){
        this.visaStatusDao = visaStatusDao;
    }

    public List<VisaStatus> getAllVisaStatus(){
        return this.visaStatusDao.getVisaStatus();
    }

    public VisaStatus getVisaStatusById(int id) {
        return this.visaStatusDao.getVisaStatusById(id);
    }

    public Integer updateVisa(VisaStatus visa) {
        return visaStatusDao.updateVisa(visa);
    }
}
