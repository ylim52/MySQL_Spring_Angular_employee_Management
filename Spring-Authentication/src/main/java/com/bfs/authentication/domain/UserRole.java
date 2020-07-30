package com.bfs.authentication.domain;

import lombok.*;

import javax.persistence.*;

@Entity @AllArgsConstructor
@NoArgsConstructor @Getter
@Setter @ToString
@Table(name = "UserRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Integer UserID;
//    private Integer RoleID;
    private Integer ActiveFlag;
    private String CreateDate;
    private String ModificationDate;
    private String LastModificationUser;

    @ManyToOne
    @JoinColumn(name = "RoleID")
    private Role roles;
}