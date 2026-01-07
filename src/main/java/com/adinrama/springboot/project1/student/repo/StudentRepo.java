package com.adinrama.springboot.project1.student.repo;

import com.adinrama.springboot.project1.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM students WHERE id = ?1", nativeQuery = true)
    Student getStudentById(Long id);

}
