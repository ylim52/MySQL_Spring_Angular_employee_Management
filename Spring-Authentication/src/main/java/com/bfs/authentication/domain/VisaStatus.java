package com.bfs.authentication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity @AllArgsConstructor
@NoArgsConstructor @Getter
@Setter @ToString @Table(name = "VisaStatus")
public class VisaStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name="VisaType")
    private String visaType;

    @Column(name="Active")
    private Integer active;

    @Column(name="ModificationUser")
    private String modificationUser;

    @Column(name="CreateUser")
    private String createUser;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="ID")
    private Employee employee;

}
