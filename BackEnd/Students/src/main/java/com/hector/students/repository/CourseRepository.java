package com.hector.students.repository;

import com.hector.students.model.Course;
import com.hector.students.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Set<Course> findAllByStudents(Student student);

}
