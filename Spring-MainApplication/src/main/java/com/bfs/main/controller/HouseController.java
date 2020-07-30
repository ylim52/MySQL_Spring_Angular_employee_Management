package com.bfs.main.controller;

import com.bfs.main.domain.Employee;
import com.bfs.main.domain.FacilityReportDetail;
import com.bfs.main.domain.House;
import com.bfs.main.service.FacilityReportDetailService;
import com.bfs.main.service.FacilityReportService;
import com.bfs.main.service.HouseService;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HouseController{
    private HouseService houseService;
    private FacilityReportDetailService facilityreportdetailservice;
    private FacilityReportService facilityreportservice;

    @Autowired
    private void setHouseService(HouseService houseService){
        this.houseService = houseService;
    }

    @Autowired
    private void setFacilityReportService(FacilityReportDetailService facilityreportdetailservice){
        this.facilityreportdetailservice = facilityreportdetailservice;
    }

    @Autowired
    private void setFacilityReportService(FacilityReportService facilityreportservice){
        this.facilityreportservice = facilityreportservice;
    }


    @GetMapping("/house")
    @ResponseBody
    public List<House> getHouse(){
        return this.houseService.getHouse();
    }

    @GetMapping("/house/id")
    public House getHouseById(@RequestParam("id") int id){
        House house = houseService.getHouseById(id);
        return house;
    }

    @PostMapping("/house/update-comments")
    public FacilityReportDetail updateComments(@RequestBody FacilityReportDetail facilityReportDetail){
        return this.facilityreportdetailservice.updateComments(facilityReportDetail);
    }

    @PostMapping("/house/add-report")
    public void addReport(){
        this.facilityreportservice.addFacilityReport();
    }
}