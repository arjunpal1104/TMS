package com.skill2skill.taskmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="Designation")
@Table(name ="designation")
@Accessors(chain = true)
@Builder
public class Designation{

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer designationId;
    @Column(name = "company_Name")
    private String companyName;
    @Column(name = "department_Name")
    private String departmentName;
    @Column(name = "designation_Name")
    private String designationName;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name ="designation_Status")
    private Integer designationStatus;

    @ManyToOne
    @JoinColumn(name = "departmentId") // Assuming "departmentId" is the foreign key in the "designation" table
    private Department department;


}
