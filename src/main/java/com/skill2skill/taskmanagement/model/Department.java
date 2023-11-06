package com.skill2skill.taskmanagement.model;

import ch.qos.logback.core.model.INamedModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.xml.namespace.QName;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Department")
@Table(name = "department")
@Accessors(chain = true)
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer departmentId;
    @Column(name = "department_Name")
    private String departmentName;
    @Column(name = "department_status")
    private Integer departmentStatus;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "created_by")
    private Integer createdBy;

//    @Column(name = "company_Id")
//    private Integer companyId;
    @Column(name = "company_name")
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "company_Id")
    private Company Company;


    @OneToMany(mappedBy = "department",cascade = CascadeType.REMOVE)
    private List<Designation>designations;

}
