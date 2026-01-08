package com.adinrama.springboot.project1.lecture.controller;

import com.adinrama.springboot.project1.lecture.dto.CreateLectureDTO;
import com.adinrama.springboot.project1.lecture.dto.GetLectureDTO;
import com.adinrama.springboot.project1.lecture.dto.UpdateLectureDTO;
import com.adinrama.springboot.project1.lecture.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping("/get-lecturers")
    public List<GetLectureDTO> getAllLecturers() {
        return lectureService.getAllLecturers();
    }

    @GetMapping("/get-lecture")
    public GetLectureDTO getLecture(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nidn,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        if (id != null) {
            return lectureService.getLectureById(id);
        }
        else if (nidn != null) {
            return lectureService.getLectureByNidn(nidn);
        }
        else if (name != null) {
            return lectureService.getLectureByName(name);
        }
        else {
            return lectureService.getLectureByEmail(email);
        }
    }

    @PostMapping("/create-lecture")
    public CreateLectureDTO createLecture(@RequestBody CreateLectureDTO lectureDTO) {
        return lectureService.createLecture(lectureDTO);
    }

    @PatchMapping("/update-lecture/{lectureId}")
    public UpdateLectureDTO updateLecture(@PathVariable Long lectureId, @RequestBody UpdateLectureDTO lectureDTO) {
        return lectureService.updateLecture(lectureId, lectureDTO);
    }

    @DeleteMapping("/remove-lecture/{lectureId}")
    public String removeLecture(@PathVariable Long lectureId) {
        return lectureService.removeLecture(lectureId);
    }

}
