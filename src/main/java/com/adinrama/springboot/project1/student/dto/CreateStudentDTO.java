package com.adinrama.springboot.project1.student.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentDTO {

    private String nim;
    private String email;
    private String name;
    private String faculty;
    private String department;
    private int semester;

}
