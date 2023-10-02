package com.hector.students.controller.dto.response;

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
public class CourseResponse {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String code;
    @JsonProperty
    private String title;
    @JsonProperty
    private String description;
    @JsonProperty
    private List<StudentResponse> students;
}
