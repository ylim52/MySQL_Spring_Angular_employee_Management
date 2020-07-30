package com.bfs.authentication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity @AllArgsConstructor
@NoArgsConstructor @Getter
@Setter @ToString
@Table(name = "ApplicationWorkFlow")
public class ApplicationWorkFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name="CreatedDate")
    private String createdDate;

    @Column(name="ModificationDate")
    private String modificationDate;

    @Column(name="Status")
    private String status;

    @Column(name="Comments")
    private String comments;

    @Column(name="Type")
    private String type;

    @JsonIgnore
    @OneToOne(mappedBy = "applicationWorkFlow", fetch = FetchType.EAGER)
    private Employee employee;
}
