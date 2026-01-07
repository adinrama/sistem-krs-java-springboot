package com.adinrama.springboot.project1.student.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentDTO {

    private Long id;
    private String nim;
    private String name;
    private String email;
    private String faculty;
    private String department;
    private int semester;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
