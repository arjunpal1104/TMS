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
public class AdminLoginRegistrationRequest {

    @JsonProperty(value = "email")
    @NotBlank(message = "Please provide valid email")
    private String email;

    @JsonProperty(value = "password")
    @NotBlank(message = "Please provide valid password")
    private String password;

    @JsonProperty(value = "Admin_status")
    @Min(value = 0, message = "Please provide valid Admin_status (0 -> in-active, 1 -> active)")
    @Max(value = 1, message = "Please provide valid Admin_status (0 -> in-active, 1 -> active)")
    private Integer AdminStatus;

}
