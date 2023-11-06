package com.skill2skill.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUpdateCompanyDetailsRequest {

    @JsonProperty(value = "company_id")
    private Integer companyId;

    @JsonProperty(value = "company_name")
    @NotBlank(message = "Please provide valid company name")
    private String companyName;

    @JsonProperty(value = "pan")
    @NotBlank(message = "Please provide valid pan")
    private String pan;

    @JsonProperty(value = "location")
    @NotBlank(message = "Please provide valid location")
    private String location;

    @JsonProperty(value = "company_status")
    @Min(value = 0, message = "Please provide valid company_status (0 -> in-active, 1 -> active)")
    @Max(value = 1, message = "Please provide valid company_status (0 -> in-active, 1 -> active)")
    private Integer companyStatus;
}
