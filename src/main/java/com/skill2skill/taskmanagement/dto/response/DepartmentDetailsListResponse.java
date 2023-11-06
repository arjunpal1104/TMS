package com.skill2skill.taskmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class DepartmentDetailsListResponse {
    @JsonProperty(value = "department_status")
    private Integer departmentStatus;
    @JsonProperty(value = "message")
    private String message;
    @JsonProperty(value = "department_Details")
    private List<DepartmentDetail> departmentList;
}
