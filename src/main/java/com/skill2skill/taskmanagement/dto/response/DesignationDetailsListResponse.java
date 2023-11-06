package com.skill2skill.taskmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class DesignationDetailsListResponse{
    @JsonProperty(value = "designation_status")
    private Integer departmentStatus;
    @JsonProperty(value = "message")
    private String message;
    @JsonProperty(value = "designation_Details")
    private List<DesignationDetails> designationList;
}
