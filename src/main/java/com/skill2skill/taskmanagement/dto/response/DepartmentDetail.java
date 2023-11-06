package com.skill2skill.taskmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class DepartmentDetail {
    @JsonProperty(value = "department_id")
    private Integer department_id;
    @JsonProperty(value = "company_name")
    private String companyName;
    @JsonProperty(value = "department_Name")
    private String departmentName;
    @JsonProperty(value = "department_status")
    private Integer departmentStatus;
}
