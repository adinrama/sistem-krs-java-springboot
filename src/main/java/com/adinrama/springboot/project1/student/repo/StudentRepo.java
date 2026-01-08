package com.adinrama.springboot.project1.student.repo;

import com.adinrama.springboot.project1.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findByNim(String nim);
    Optional<Student> findByName(String name);
    Optional<Student> findByEmail(String email);

}
