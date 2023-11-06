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
public class CompanyDetail {

    @JsonProperty(value = "company_id")
    private Integer companyId;

    @JsonProperty(value = "company_name")
    private String companyName;

    @JsonProperty(value = "pan")
    private String pan;

    @JsonProperty(value = "location")
    private String location;

    @JsonProperty(value = "company_status")
    private Integer companyStatus;

}
