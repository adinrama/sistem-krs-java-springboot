package com.adinrama.springboot.project1.student.service;

import com.adinrama.springboot.project1.student.dto.CreateStudentDTO;
import com.adinrama.springboot.project1.student.dto.GetStudentDTO;
import com.adinrama.springboot.project1.student.dto.UpdateStudentDTO;
import com.adinrama.springboot.project1.student.model.Student;
import com.adinrama.springboot.project1.student.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    // ================ Get All Students (READ) ================
    public List<GetStudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return modelMapper.map(
                students,
                new TypeToken<List<GetStudentDTO>>() {}.getType()
        );
    }

    // ================ Get Specific Student (READ) ================
    public GetStudentDTO getStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found.");
        }

        Student student = studentRepository.getStudentById(studentId);
        return modelMapper.map(
                student,
                GetStudentDTO.class
        );
    }

    // ================ Create Student (CREATE) ================
    public CreateStudentDTO createStudent(CreateStudentDTO studentDTO) {
        Student student = modelMapper.map(
                studentDTO,
                Student.class
        );
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(
                studentRepository.save(student),
                CreateStudentDTO.class
        );
    }

    // ================ Update Student (UPDATE) ================
    public UpdateStudentDTO updateStudent(Long studentId, UpdateStudentDTO studentDTO) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found."));

        if (studentDTO.getName() != null) {
            student.setName(studentDTO.getName());
        }

        if (studentDTO.getEmail() != null) {
            student.setEmail(studentDTO.getEmail());
        }

        student.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(
                studentRepository.save(student),
                UpdateStudentDTO.class
        );
    }

    // ================ Remove Student (DELETE) ================
    public String removeStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found.");
        }

        studentRepository.deleteById(studentId);
        return "Student deleted successfully.";
    }

}
