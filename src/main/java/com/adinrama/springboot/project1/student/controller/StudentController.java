package com.adinrama.springboot.project1.student.controller;

import com.adinrama.springboot.project1.student.dto.CreateStudentDTO;
import com.adinrama.springboot.project1.student.dto.GetStudentDTO;
import com.adinrama.springboot.project1.student.dto.UpdateStudentDTO;
import com.adinrama.springboot.project1.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-students")
    public List<GetStudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student/{studentId}")
    public GetStudentDTO getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping("/create-student")
    public CreateStudentDTO createStudent(@RequestBody CreateStudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @PatchMapping("/update-student/{studentId}")
    public UpdateStudentDTO updateStudent(@PathVariable Long studentId, @RequestBody UpdateStudentDTO studentDTO) {
        return studentService.updateStudent(studentId, studentDTO);
    }

    @DeleteMapping("/remove-student/{studentId}")
    public String removeStudent(@PathVariable Long studentId) {
        return studentService.removeStudent(studentId);
    }

}
