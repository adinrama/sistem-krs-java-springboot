package com.adinrama.springboot.project1.lecture.seeder;

import com.adinrama.springboot.project1.lecture.model.Lecture;
import com.adinrama.springboot.project1.lecture.repo.LectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Profile("dev")
public class LectureSeeder implements CommandLineRunner {

    @Autowired
    private LectureRepo lectureRepository;

    @Override
    public void run(String... args) {
        if (lectureRepository.count() > 0) {
            return;
        }

        List<Lecture> lecturers = List.of(
                new Lecture(
                        null,
                        "010012026",
                        "adi@yahoo.id",
                        "Adi Wahyu Santosa",
                        "Departemen Teknik Informatika",
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Lecture(
                        null,
                        "010022026",
                        "dirga@yahoo.id",
                        "Dirga Putri Rahayu",
                        "Departemen Ilmu Ekonomi",
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Lecture(
                        null,
                        "010032026",
                        "yulia@yahoo.id",
                        "Yulia Farida",
                        "Departemen Sistem Informasi",
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Lecture(
                        null,
                        "010042026",
                        "bambang@yahoo.id",
                        "Bambang Hartono",
                        "Departemen Teknik Sipil",
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                )
        );

        lectureRepository.saveAll(lecturers);
        System.out.println("✔ Lecture seeder executed");

    }

}
