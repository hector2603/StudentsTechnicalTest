package com.hector.students.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCourseRequest {

    @JsonProperty
    private Long idStudent;
    @JsonProperty
    private Long idCourse;

}
