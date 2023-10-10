package com.skill2skill.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationRequest{

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "Email")
    private  String Email;
    @JsonProperty(value = "Password")
    private  String Password;
    @JsonProperty(value ="Role")
    private  String Role;
    @JsonProperty(value ="Department")
    private  String Department;


}
