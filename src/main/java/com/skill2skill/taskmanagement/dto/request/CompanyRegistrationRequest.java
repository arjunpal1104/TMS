package com.skill2skill.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CompanyRegistrationRequest {
    @JsonProperty(value = "companyName")
    private String companyName;
    @JsonProperty(value = "companyEmail")
    private String companyEmail;
    @JsonProperty(value = "companyContact")
    private String companyContact;
    @JsonProperty(value = "companyAddress")
    private String companyAddress;
}
