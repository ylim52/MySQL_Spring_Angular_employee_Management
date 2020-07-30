package com.bfs.authentication.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Table(name="Person")
@Getter @Setter @ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="MiddleName")
    private String middleName;

    @Column(name="Email")
    private String email;

    @Column(name="CellPhone")
    private String cellPhone;

    @Column(name="AlternatePhone")
    private String altPhone;

    @Column(name="Gender")
    private String gender;

    @Column(name="SSN")
    private String ssn;

    @Column(name="DOB")
    private String dob;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID")
    private Address address;

}
