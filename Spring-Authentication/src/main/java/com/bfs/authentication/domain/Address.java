package com.bfs.authentication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @AllArgsConstructor
@NoArgsConstructor @Getter
@Setter @ToString
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="AddressLine1")
    private String AddressLine1;

    @Column(name="AddressLine2")
    private String AddressLine2;

    @Column(name="City")
    private String City;

    @Column(name="ZipCode")
    private String Zipcode;

    @Column(name="StateName")
    private String StateName;

    @Column(name="StateAbbr")
    private String StateAbbr;

    @JsonIgnore
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "address")
    private List<Person> persons;

}
