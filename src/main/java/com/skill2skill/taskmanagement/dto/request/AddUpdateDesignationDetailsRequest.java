package com.skill2skill.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors
public class AddUpdateDesignationDetailsRequest {
    @JsonProperty(value = "designation_Id")
    private Integer designationId;
    @NotBlank(message = "Please enter company name")
    @JsonProperty(value = "company_Name")
    private String companyName;
    @NotBlank(message = "Please enter department")
    @JsonProperty(value = "department")
    private String department;
    @NotBlank(message = "Please enter designation")
    @JsonProperty(value = "designation")
    private String designation;

    @JsonProperty(value = "designation_status")
    @Min(value = 0, message = "Please provide valid designation_status (0 -> in-active, 1 -> active)")
    @Max(value = 1, message = "Please provide valid designation_status (0 -> in-active, 1 -> active)")
    private Integer designationStatus;
}
