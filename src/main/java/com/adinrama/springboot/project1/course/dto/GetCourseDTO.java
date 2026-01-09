package com.adinrama.springboot.project1.course.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCourseDTO {

    private Long id;
    private String courseCode;
    private String courseName;
    private String semester;
    private Integer credit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
