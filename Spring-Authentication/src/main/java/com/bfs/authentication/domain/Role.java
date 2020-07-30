package com.bfs.authentication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @AllArgsConstructor
@NoArgsConstructor @Getter
@Setter @ToString
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String RoleName;
    private String Description;
    private String CreateDate;
    private String ModificationDate;
    private String LastModificationUser;

    @JsonIgnore
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "roles")
    private List<UserRole> connections;
}