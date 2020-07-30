package com.bfs.main.service;

import com.bfs.main.dao.implementation.FacilityReportDetailDao;
import com.bfs.main.domain.FacilityReportDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacilityReportDetailService {

    private FacilityReportDetailDao facilityReportDetailDao;

    @Autowired
    public void setApplicationWorkFlowDao(FacilityReportDetailDao facilityReportDetailDao){
        this.facilityReportDetailDao = facilityReportDetailDao;
    }

    public List<FacilityReportDetail> getAll(){
        return this.facilityReportDetailDao.getAll();
    }

    public FacilityReportDetail updateComments(FacilityReportDetail facilityReportDetail) {
        return this.facilityReportDetailDao.updateComments((facilityReportDetail));
    }
}
