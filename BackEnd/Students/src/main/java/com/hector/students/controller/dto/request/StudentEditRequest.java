package com.hector.students.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEditRequest {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String firstName;
}
