package com.adinrama.springboot.project1.krs.model;

import com.adinrama.springboot.project1.course.model.Course;
import com.adinrama.springboot.project1.student.model.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "krs")
public class KRS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String academicYear;

    @Enumerated(EnumType.STRING)
    private SemesterType semesterType;  // GANJIL / GENAP

    @Enumerated(EnumType.STRING)
    private KRSStatus status;   // ACTIVE / DROPPED

    private String grade;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
