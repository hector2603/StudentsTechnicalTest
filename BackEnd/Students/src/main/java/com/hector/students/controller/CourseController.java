package com.hector.students.controller;

import com.hector.students.controller.dto.request.CourseCreateRequest;
import com.hector.students.controller.dto.request.CourseEditRequest;
import com.hector.students.controller.dto.response.CourseResponse;
import com.hector.students.controller.dto.response.MessageRespone;
import com.hector.students.exceptions.BussinesException;
import com.hector.students.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/course")
@Tag(name = "CourseController", description = "Controller to manage the courses for the students")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    @Operation(summary = "Create Course", description = "This method creates a course with the specific body")
    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseCreateRequest courseCreateRequest){
        CourseResponse courseResponse = courseService.createCourse(courseCreateRequest);
        return ResponseEntity.ok(courseResponse);
    }

    @PatchMapping
    @Operation(summary = "Update Course", description = "This method updates a course depends the specific id in the body")
    public ResponseEntity<CourseResponse> editCourse(@RequestBody CourseEditRequest courseEditRequest) throws BussinesException {
        CourseResponse courseResponse = courseService.updateCourse(courseEditRequest);
        return ResponseEntity.ok(courseResponse);
    }

    @DeleteMapping("/{course-id}")
    @Operation(summary = "Delete Course", description = "This method deletes a course")
    public ResponseEntity<MessageRespone> deleteCourse(@PathVariable("course-id") Long courseId) throws BussinesException {
        MessageRespone messageRespone = courseService.deleteCourse(courseId);
        return ResponseEntity.ok(messageRespone);
    }

    @GetMapping
    @Operation(summary = "List Courses", description = "This method Fetches all the courses in the data base")
    public ResponseEntity<List<CourseResponse>> ListCourses(){
        List<CourseResponse> listCourses = courseService.listCourse();
        return ResponseEntity.ok(listCourses);
    }

    @GetMapping("/{course-id}")
    @Operation(summary = "Find Course", description = "This method finds a especific course in the data base")
    public ResponseEntity<CourseResponse> FindCourse(@PathVariable("course-id") Long courseId) throws BussinesException {
        CourseResponse course = courseService.findCourse(courseId);
        return ResponseEntity.ok(course);
    }

}
