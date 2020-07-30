package com.bfs.authentication.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity @Table(name="Employee")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@PrimaryKeyJoinColumn(name = "ID")
public class Employee extends Person{

    @Column(name="Title")
    private String title;

    @Column(name="ManagerID")
    private Integer managerId;

    @Column(name="StartDate")
    private String startDate;

    @Column(name="EndDate")
    private String endDate;

    private String Avatar;

    @Column(name="Car")
    private String car;

    @Column(name="VisaStatusID")
    private Integer visaID;

    @Column(name="VisaStartDate")
    private String visaStart;

    @Column(name="VisaEndDate")
    private String visaEnd;

    @Column(name="DriverLicence")
    private String license;

    @Column(name="DriverLicence_ED")
    private String licenseED;

    private Integer HouseID;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID")
    private ApplicationWorkFlow applicationWorkFlow;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(mappedBy="employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private VisaStatus visaStatus;
}
