package com.hector.students.services;

import com.hector.students.controller.dto.request.AddCourseRequest;
import com.hector.students.controller.dto.request.StudentCreateRequest;
import com.hector.students.controller.dto.request.StudentEditRequest;
import com.hector.students.controller.dto.response.MessageRespone;
import com.hector.students.controller.dto.response.StudentResponse;
import com.hector.students.exceptions.BussinesException;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentCreateRequest studentCreateRequest);
    StudentResponse updateStudent(StudentEditRequest studentEditRequest) throws BussinesException;
    MessageRespone deleteStudent(Long id) throws BussinesException;
    List<StudentResponse> listStudent();
    StudentResponse addCourse(AddCourseRequest addCourseRequest) throws BussinesException;
    StudentResponse FindStudent(Long id) throws BussinesException;
}
