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

    @GetMapping("/get-student")
    public GetStudentDTO getStudent(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nim,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        if (id != null) {
            return studentService.getStudentById(id);
        }
        else if (nim != null) {
            return studentService.getStudentByNim(nim);
        }
        else if (name != null) {
            return studentService.getStudentByName(name);
        }
        else {
            return studentService.getStudentByEmail(email);
        }
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
