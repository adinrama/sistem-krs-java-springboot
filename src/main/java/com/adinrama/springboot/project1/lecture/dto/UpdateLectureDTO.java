package com.adinrama.springboot.project1.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLectureDTO {

    private String name;
    private String email;
    private String department;

}
