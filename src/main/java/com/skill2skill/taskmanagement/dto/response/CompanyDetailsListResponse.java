package com.skill2skill.taskmanagement.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDetailsListResponse {

    @JsonProperty(value = "status")
    private Integer status;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "company_details")
    private List<CompanyDetail> companyDetails;
}
