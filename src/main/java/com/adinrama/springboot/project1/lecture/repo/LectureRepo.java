package com.adinrama.springboot.project1.lecture.repo;

import com.adinrama.springboot.project1.lecture.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, Long> {

    Optional<Lecture> findByNidn(String nidn);
    Optional<Lecture> findByName(String name);
    Optional<Lecture> findByEmail(String email);

}
