package com.hector.students.controller;

import com.hector.students.controller.dto.request.AddCourseRequest;
import com.hector.students.controller.dto.request.StudentCreateRequest;
import com.hector.students.controller.dto.request.StudentEditRequest;
import com.hector.students.controller.dto.response.MessageRespone;
import com.hector.students.controller.dto.response.StudentResponse;
import com.hector.students.exceptions.BussinesException;
import com.hector.students.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/student")
@Tag(name = "StudentController", description = "Controller to manage the students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @Operation(summary = "Create Student", description = "This method creates a Student with the specific body")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentCreateRequest studentCreateRequest){
        StudentResponse studentResponse = studentService.createStudent(studentCreateRequest);
        return ResponseEntity.ok(studentResponse);
    }

    @PostMapping("/addCourse")
    @Operation(summary = "Add course to student", description = "This method add a specific course to student")
    public ResponseEntity<StudentResponse> addCourse(@RequestBody AddCourseRequest addCourseRequest) throws BussinesException {
        StudentResponse studentResponse = studentService.addCourse(addCourseRequest);
        return ResponseEntity.ok(studentResponse);
    }

    @PatchMapping
    @Operation(summary = "Update Student", description = "This method updates a Student depends the specific id in the body")
    public ResponseEntity<StudentResponse> editStudent(@RequestBody StudentEditRequest studentEditRequest) throws BussinesException {
        StudentResponse studentResponse = studentService.updateStudent(studentEditRequest);
        return ResponseEntity.ok(studentResponse);
    }

    @DeleteMapping("/{student-id}")
    @Operation(summary = "Delete Student", description = "This method Student a course")
    public ResponseEntity<MessageRespone> deleteStudent(@PathVariable("student-id") Long studentId) throws BussinesException {
        MessageRespone messageRespone = studentService.deleteStudent(studentId);
        return ResponseEntity.ok(messageRespone);
    }

    @GetMapping
    @Operation(summary = "List Student", description = "This method Fetches all the Student in the data base")
    public ResponseEntity<List<StudentResponse>> ListStudents(){
        List<StudentResponse> listStudents = studentService.listStudent();
        return ResponseEntity.ok(listStudents);
    }

    @GetMapping("/{student-id}")
    @Operation(summary = "Find Student", description = "This method finds a specific Student in the data base")
    public ResponseEntity<StudentResponse> FindStudent(@PathVariable("student-id") Long studentId) throws BussinesException {
        StudentResponse student = studentService.FindStudent(studentId);
        return ResponseEntity.ok(student);
    }

}
