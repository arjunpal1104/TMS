package com.skill2skill.taskmanagement.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class DesignationDetails {

    @JsonProperty(value = "company_Name")
    private String companyName;
    @JsonProperty(value ="department")
    private String department;
    @JsonProperty(value ="designation")
    private String designation;
    @JsonProperty(value = "designaiton_status")
    private Integer designationStatus;
}
