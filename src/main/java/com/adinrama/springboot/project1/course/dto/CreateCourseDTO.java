package com.adinrama.springboot.project1.course.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseDTO {

    private String courseCode;
    private String courseName;
    private String semester;
    private Integer credit;

}
