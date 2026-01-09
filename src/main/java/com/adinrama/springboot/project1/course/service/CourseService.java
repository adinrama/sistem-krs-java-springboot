package com.adinrama.springboot.project1.course.service;

import com.adinrama.springboot.project1.course.dto.CreateCourseDTO;
import com.adinrama.springboot.project1.course.dto.GetCourseDTO;
import com.adinrama.springboot.project1.course.dto.UpdateCourseDTO;
import com.adinrama.springboot.project1.course.model.Course;
import com.adinrama.springboot.project1.course.repo.CourseRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    // ================ Get All Courses (READ) ================
    public List<GetCourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return modelMapper.map(
                courses,
                new TypeToken<List<GetCourseDTO>>() {}.getType()
        );
    }

    // ================ Get Specific Course (READ) ================
    public GetCourseDTO getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found."));

        return modelMapper.map(
                course,
                GetCourseDTO.class
        );
    }

    public GetCourseDTO getCourseByCode(String courseCode) {
        Course course = courseRepository.findByCourseCode(courseCode)
                .orElseThrow(() -> new RuntimeException("Course not found."));

        return modelMapper.map(
                course,
                GetCourseDTO.class
        );
    }

    public GetCourseDTO getCourseByName(String courseName) {
        Course course = courseRepository.findByCourseName(courseName)
                .orElseThrow(() -> new RuntimeException("Course not found."));

        return modelMapper.map(
                course,
                GetCourseDTO.class
        );
    }

    // ================ Add Course (CREATE) ================
    public CreateCourseDTO addCourse(CreateCourseDTO courseDTO) {
        Course course = modelMapper.map(
                courseDTO,
                Course.class
        );
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(
                courseRepository.save(course),
                CreateCourseDTO.class
        );
    }

    // ================ Update Course (UPDATE) ================
    public UpdateCourseDTO updateCourse(Long courseId, UpdateCourseDTO courseDTO) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found."));

        if (courseDTO.getCourseName() != null) {
            course.setCourseName(courseDTO.getCourseName());
        }

        if (courseDTO.getSemester() != null) {
            course.setSemester(courseDTO.getSemester());
        }

        if (courseDTO.getCredit() != null) {
            course.setCredit(courseDTO.getCredit());
        }

        course.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(
                courseRepository.save(course),
                UpdateCourseDTO.class
        );
    }

    // ================ Remove Course (DELETE) ================
    public String removeCourse(Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new RuntimeException("Course not found.");
        }

        courseRepository.deleteById(courseId);
        return "Course deleted successfully.";
    }

}
