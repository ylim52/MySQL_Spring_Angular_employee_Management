package com.bfs.authentication.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Username;
    private String Email;
    private String Password;
    @OneToOne
    @JoinColumn(name="PersonID_User", referencedColumnName = "ID")
    private Employee employee;
    private String CreateDate;
    private String ModificationDate;

}
