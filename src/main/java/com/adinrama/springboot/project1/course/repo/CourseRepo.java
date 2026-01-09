package com.adinrama.springboot.project1.course.repo;

import com.adinrama.springboot.project1.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {

    Optional<Course> findByCourseCode(String courseCode);
    Optional<Course> findByCourseName(String courseName);

}
