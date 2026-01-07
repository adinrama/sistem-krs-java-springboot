package com.adinrama.springboot.project1.student.model;

import com.adinrama.springboot.project1.krs.model.KRS;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nim;

    private String name;
    private String email;
    private String faculty;
    private String department;
    private int semester;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "student")
    private List<KRS> krsList;

}
