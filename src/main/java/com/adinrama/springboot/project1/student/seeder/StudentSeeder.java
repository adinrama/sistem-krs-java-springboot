package com.adinrama.springboot.project1.student.seeder;

import com.adinrama.springboot.project1.student.model.Student;
import com.adinrama.springboot.project1.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Profile("dev")
public class StudentSeeder implements CommandLineRunner {

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public void run(String... args) {

        if (studentRepository.count() > 0) {
            return;
        }

        List<Student> students = List.of(
                new Student(
                        null,
                        "250012026",
                        "Surya Kertanegara",
                        "surya@yahoo.id",
                        "Fakultas Hukum",
                        "Ilmu Hukum",
                        6,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Student(
                        null,
                        "250022026",
                        "Hidayatul Ulum",
                        "hidayatul@yahoo.id",
                        "Fakultas MIPA",
                        "Matematika",
                        6,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Student(
                        null,
                        "250032026",
                        "Hendra Gunawan",
                        "hendra@yahoo.id",
                        "Fakultas Teknik",
                        "Teknik Mesin",
                        8,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Student(
                        null,
                        "250042026",
                        "Bayu Rahadian",
                        "bayu@yahoo.id",
                        "Fakultas Teknik",
                        "Teknik Elektro",
                        4,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Student(
                        null,
                        "250052026",
                        "Ajeng Sasmito",
                        "ajeng@yahoo.id",
                        "Fakultas Kedokteran",
                        "Ilmu Gizi",
                        8,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                ),
                new Student(
                        null,
                        "250062026",
                        "Nisrina Ayu Pambudi",
                        "nisrina@yahoo.id",
                        "Fakultas Ilmu Komputer",
                        "Sistem Informasi",
                        4,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null
                )
        );

        studentRepository.saveAll(students);
        System.out.println("✔ Student seeder executed");

    }

}
