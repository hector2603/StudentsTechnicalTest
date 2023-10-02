package com.hector.students.services.impl;

import com.hector.students.controller.dto.request.AddCourseRequest;
import com.hector.students.controller.dto.request.StudentCreateRequest;
import com.hector.students.controller.dto.request.StudentEditRequest;
import com.hector.students.controller.dto.response.MessageRespone;
import com.hector.students.controller.dto.response.StudentResponse;
import com.hector.students.exceptions.BussinesException;
import com.hector.students.mapper.Mapper;
import com.hector.students.model.Course;
import com.hector.students.model.Student;
import com.hector.students.repository.CourseRepository;
import com.hector.students.repository.StudentRepository;
import com.hector.students.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.hector.students.Constants.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private Mapper mapper;
    @Override
    public StudentResponse createStudent(StudentCreateRequest studentCreateRequest) {
        Student student = new Student();
        BeanUtils.copyProperties(studentCreateRequest,student);
        studentRepository.save(student);
        return mapper.studentToStudentResponse(student,Boolean.FALSE);
    }

    @Override
    public StudentResponse updateStudent(StudentEditRequest studentEditRequest) throws BussinesException {
        Student student = studentRepository.findById(studentEditRequest.getId()).orElseThrow(() ->new BussinesException(STUDENT_NOT_FOUND));
        BeanUtils.copyProperties(studentEditRequest,student);
        studentRepository.save(student);
        return mapper.studentToStudentResponse(student,Boolean.TRUE);
    }


    @Override
    public MessageRespone deleteStudent(Long id) throws BussinesException {
        Student student = studentRepository.findById(id).orElseThrow(() ->new BussinesException(STUDENT_NOT_FOUND));
        studentRepository.delete(student);
        return MessageRespone.builder().message(STUDENT_DELETED_SUCCESSFULLY).build();
    }

    @Override
    public List<StudentResponse> listStudent() {
        return StreamSupport.stream( studentRepository.findAll().spliterator(), false)
                .map( student -> {
                        student.setCourses(courseRepository.findAllByStudents(student));
                        return student;
                    } )
                .map( student -> mapper.studentToStudentResponse(student,Boolean.TRUE))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse addCourse(AddCourseRequest addCourseRequest) throws BussinesException {
        Student student = studentRepository.findById(addCourseRequest.getIdStudent()).orElseThrow(() ->new BussinesException(STUDENT_NOT_FOUND));
        Course course = courseRepository.findById(addCourseRequest.getIdCourse()).orElseThrow(() ->new BussinesException(COURSE_NOT_FOUND));
        student.getCourses().add(course);
        studentRepository.save(student);
        return mapper.studentToStudentResponse(student,Boolean.TRUE);
    }

    @Override
    public StudentResponse FindStudent(Long id) throws BussinesException {
        Student student = studentRepository.findById(id).orElseThrow(() ->new BussinesException(STUDENT_NOT_FOUND));
        Set<Course> courses = courseRepository.findAllByStudents(student);
        student.setCourses(courses);
        return  mapper.studentToStudentResponse(student,Boolean.TRUE);
    }
}
