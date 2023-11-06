package com.skill2skill.taskmanagement.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.skill2skill.taskmanagement.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUpdateDepartmentDetailsRequest {

    @JsonProperty(value ="department_id")
    private Integer id;
    @JsonProperty(value = "company_name")
    @NotBlank(message = "Please provide valid companyName")
    private String companyName;
    @JsonProperty(value = "department")
    @NotBlank(message ="Please provide valid department")
    private String department;

    @JsonProperty(value = "department_status")
    @Min(value = 0, message = "Please provide valid Department_status (0 -> in-active, 1 -> active)")
    @Max(value = 1, message = "Please provide valid Department_status (0 -> in-active, 1 -> active)")
    private Integer departmentStatus;
}
