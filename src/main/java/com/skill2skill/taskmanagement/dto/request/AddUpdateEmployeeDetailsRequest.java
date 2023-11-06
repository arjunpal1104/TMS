package com.skill2skill.taskmanagement.dto.request;

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
public class AddUpdateEmployeeDetailsRequest {
    @JsonProperty(value ="company_Name")
    public String companyName;
    @JsonProperty(value ="Department_Name")
    public String departmentName;
    @JsonProperty(value ="designation_Name")
    public String designationName;
    @JsonProperty(value ="employee_Name")
    public String employeeName;
    @JsonProperty(value ="employee_dob")
    public String employeeDob;
    @JsonProperty(value ="adhare_Number")
    public Integer adhareNumber;
    @JsonProperty(value ="email")
    public String email;
    @JsonProperty(value ="contact")
    public String contact;
}
