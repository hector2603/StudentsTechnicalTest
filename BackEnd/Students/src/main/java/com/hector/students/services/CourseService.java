package com.hector.students.services;

import com.hector.students.controller.dto.request.AddCourseRequest;
import com.hector.students.controller.dto.request.CourseCreateRequest;
import com.hector.students.controller.dto.request.CourseEditRequest;
import com.hector.students.controller.dto.response.MessageRespone;
import com.hector.students.controller.dto.response.CourseResponse;
import com.hector.students.exceptions.BussinesException;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CourseCreateRequest courseCreateRequest);
    CourseResponse updateCourse(CourseEditRequest courseEditRequest) throws BussinesException;
    MessageRespone deleteCourse(Long id) throws BussinesException;
    List<CourseResponse> listCourse();
    CourseResponse findCourse(Long id) throws BussinesException;
}
