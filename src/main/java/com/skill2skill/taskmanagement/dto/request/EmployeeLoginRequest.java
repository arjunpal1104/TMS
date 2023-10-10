package com.skill2skill.taskmanagement.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLoginRequest {
    @JsonProperty(value ="Email")
    private  String Email;
    @JsonProperty(value ="Password")
    private String Password;


}
