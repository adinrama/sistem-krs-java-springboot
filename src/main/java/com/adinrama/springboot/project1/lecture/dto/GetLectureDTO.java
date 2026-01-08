package com.adinrama.springboot.project1.lecture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetLectureDTO {

    private Long id;
    private String nidn;
    private String email;
    private String name;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
