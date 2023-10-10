package com.skill2skill.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Company")
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "companyEmail")
    private String companyEmail;
    @Column(name = "companyContact")
    private String companyContact;
    @Column(name = "companyAddress")
    private String companyAddress;
    @Column(name = "companyCode")
    private  String companyCode;

}
