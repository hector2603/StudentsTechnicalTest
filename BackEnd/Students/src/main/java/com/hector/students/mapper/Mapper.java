package com.hector.students.mapper;

import com.hector.students.controller.dto.response.CourseResponse;
import com.hector.students.controller.dto.response.StudentResponse;
import com.hector.students.model.Course;
import com.hector.students.model.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {


    public StudentResponse studentToStudentResponse(Student student, Boolean mapCourses){
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(student,studentResponse);
        if(mapCourses)
            studentResponse.setCourses(student.getCourses().stream().map(curse -> courseToCourseResponse(curse,Boolean.FALSE)).collect(Collectors.toList()));
        return studentResponse;
    }

    public CourseResponse courseToCourseResponse(Course course, Boolean mapStudent){
        CourseResponse courseResponse = new CourseResponse();
        BeanUtils.copyProperties(course,courseResponse);
        if(mapStudent)
            courseResponse.setStudents(course.getStudents().stream().map(student -> studentToStudentResponse(student,Boolean.FALSE)).collect(Collectors.toList()));
        return courseResponse;
    }
}
