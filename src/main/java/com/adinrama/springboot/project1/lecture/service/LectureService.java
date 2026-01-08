package com.adinrama.springboot.project1.lecture.service;

import com.adinrama.springboot.project1.lecture.dto.CreateLectureDTO;
import com.adinrama.springboot.project1.lecture.dto.GetLectureDTO;
import com.adinrama.springboot.project1.lecture.dto.UpdateLectureDTO;
import com.adinrama.springboot.project1.lecture.model.Lecture;
import com.adinrama.springboot.project1.lecture.repo.LectureRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LectureService {

    @Autowired
    private LectureRepo lectureRepository;

    @Autowired
    private ModelMapper modelMapper;

    // ================ Get All Lecturers (READ) ================
    public List<GetLectureDTO> getAllLecturers() {
        List<Lecture> lecturers = lectureRepository.findAll();
        return modelMapper.map(
                lecturers,
                new TypeToken<List<GetLectureDTO>>() {}.getType()
        );
    }

    // ================ Get Specific Lecture (READ) ================
    public GetLectureDTO getLectureById(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found."));

        return modelMapper.map(
                lecture,
                GetLectureDTO.class
        );
    }

    public GetLectureDTO getLectureByNidn(String nidn) {
        Lecture lecture = lectureRepository.findByNidn(nidn)
                .orElseThrow(() -> new RuntimeException("Lecture not found."));

        return modelMapper.map(
                lecture,
                GetLectureDTO.class
        );
    }

    public GetLectureDTO getLectureByName(String name) {
        Lecture lecture = lectureRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Lecture not found."));

        return modelMapper.map(
                lecture,
                GetLectureDTO.class
        );
    }

    public GetLectureDTO getLectureByEmail(String email) {
        Lecture lecture = lectureRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Lecture not found."));

        return modelMapper.map(
                lecture,
                GetLectureDTO.class
        );
    }

    // ================ Create Lecture (CREATE) ================
    public CreateLectureDTO createLecture(CreateLectureDTO lectureDTO) {
        Lecture lecture = modelMapper.map(
                lectureDTO,
                Lecture.class
        );

        lecture.setCreatedAt(LocalDateTime.now());
        lecture.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(
                lectureRepository.save(lecture),
                CreateLectureDTO.class
        );
    }

    // ================ Update Lecture (UPDATE) ================
    public UpdateLectureDTO updateLecture(Long lectureId, UpdateLectureDTO lectureDTO) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found."));

        if (lectureDTO.getName() != null) {
            lecture.setName(lectureDTO.getName());
        }

        if (lectureDTO.getEmail() != null) {
            lecture.setEmail(lectureDTO.getEmail());
        }

        if (lectureDTO.getDepartment() != null) {
            lecture.setDepartment(lectureDTO.getDepartment());
        }

        lecture.setUpdatedAt(LocalDateTime.now());

        return modelMapper.map(
                lectureRepository.save(lecture),
                UpdateLectureDTO.class
        );
    }

    // ================ Remove Lecture (DELETE) ================
    public String removeLecture(Long lectureId) {
        if (!lectureRepository.existsById(lectureId)) {
            throw new RuntimeException("Lecture not found.");
        }

        lectureRepository.deleteById(lectureId);
        return "Lecture deleted successfully.";
    }

}
