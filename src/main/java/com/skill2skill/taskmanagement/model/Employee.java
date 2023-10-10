package com.skill2skill.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.namespace.QName;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Employee")
@Table(name = "employee",uniqueConstraints=@UniqueConstraint(columnNames = "email"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private  String password;
    @Column(name ="Role")
    private  String Role;
    @Column(name = "Department")
    private String Department;
}
