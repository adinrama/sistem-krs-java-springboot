package com.adinrama.springboot.project1.course.controller;

import com.adinrama.springboot.project1.course.dto.CreateCourseDTO;
import com.adinrama.springboot.project1.course.dto.GetCourseDTO;
import com.adinrama.springboot.project1.course.dto.UpdateCourseDTO;
import com.adinrama.springboot.project1.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get-courses")
    public List<GetCourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/get-course")
    public GetCourseDTO getCourse(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String courseCode,
            @RequestParam(required = false) String courseName
    ) {
        if (id != null) {
            return courseService.getCourseById(id);
        }
        else if (courseCode != null) {
            return courseService.getCourseByCode(courseCode);
        }
        else {
            return courseService.getCourseByName(courseName);
        }
    }

    @PostMapping("/add-course")
    public CreateCourseDTO addCourse(@RequestBody CreateCourseDTO courseDTO) {
        return courseService.addCourse(courseDTO);
    }

    @PatchMapping("/update-course/{courseId}")
    public UpdateCourseDTO updateCourse(@PathVariable Long courseId, @RequestBody UpdateCourseDTO courseDTO) {
        return courseService.updateCourse(courseId, courseDTO);
    }

    @DeleteMapping("/remove-course/{courseId}")
    public String removeCourse(@PathVariable Long courseId) {
        return courseService.removeCourse(courseId);
    }

}
