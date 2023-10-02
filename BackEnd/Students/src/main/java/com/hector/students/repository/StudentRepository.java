package com.hector.students.repository;

import com.hector.students.model.Course;
import com.hector.students.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Set<Student> findAllByCourses(Course course);

}
