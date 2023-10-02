package com.hector.students.services.impl;

import com.hector.students.controller.dto.request.AddCourseRequest;
import com.hector.students.controller.dto.request.CourseCreateRequest;
import com.hector.students.controller.dto.request.CourseEditRequest;
import com.hector.students.controller.dto.response.MessageRespone;
import com.hector.students.controller.dto.response.CourseResponse;
import com.hector.students.exceptions.BussinesException;
import com.hector.students.mapper.Mapper;
import com.hector.students.model.Course;
import com.hector.students.model.Course;
import com.hector.students.model.Student;
import com.hector.students.repository.CourseRepository;
import com.hector.students.repository.CourseRepository;
import com.hector.students.repository.StudentRepository;
import com.hector.students.services.CourseService;
import com.hector.students.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.hector.students.Constants.*;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private Mapper mapper;
    @Override
    public CourseResponse createCourse(CourseCreateRequest courseCreateRequest) {
        Course course = new Course();
        BeanUtils.copyProperties(courseCreateRequest,course);
        courseRepository.save(course);
        return mapper.courseToCourseResponse(course,Boolean.FALSE);
    }

    @Override
    public CourseResponse updateCourse(CourseEditRequest courseEditRequest) throws BussinesException {
        Course course = courseRepository.findById(courseEditRequest.getId()).orElseThrow(() ->new BussinesException(COURSE_NOT_FOUND));
        BeanUtils.copyProperties(courseEditRequest,course);
        course = courseRepository.save(course);
        return mapper.courseToCourseResponse(course, Boolean.TRUE);
    }


    @Override
    public MessageRespone deleteCourse(Long id) throws BussinesException {
        Course course = courseRepository.findById(id).orElseThrow(() ->new BussinesException(COURSE_NOT_FOUND));
        if(!studentRepository.findAllByCourses(course).isEmpty())
            throw new BussinesException(COURSE_CANT_DELETE);
        courseRepository.delete(course);
        return MessageRespone.builder().message(STUDENT_DELETED_SUCCESSFULLY).build();
    }

    @Override
    public List<CourseResponse> listCourse() {
        return StreamSupport.stream( courseRepository.findAll().spliterator(), false)
                .map( course -> {
                    course.setStudents(studentRepository.findAllByCourses(course));
                    return course;
                })
                .map( student -> mapper.courseToCourseResponse(student,Boolean.TRUE))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse findCourse(Long id) throws BussinesException {
        Course course = courseRepository.findById(id).orElseThrow(() ->new BussinesException(COURSE_NOT_FOUND));
        course.setStudents(studentRepository.findAllByCourses(course));
        return  mapper.courseToCourseResponse(course,Boolean.TRUE);
    }

}
