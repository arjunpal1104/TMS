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
public class GenericResponse {

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "message_code")
    private String messageCode;
}
