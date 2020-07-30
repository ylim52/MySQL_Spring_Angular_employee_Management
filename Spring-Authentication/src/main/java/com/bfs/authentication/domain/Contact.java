package com.bfs.authentication.domain;


import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "Contact")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Contact{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Relationship;
    private String Title;
    private Integer isReference;
    private Integer isEmergency;
    private Integer isLandlord;
}
