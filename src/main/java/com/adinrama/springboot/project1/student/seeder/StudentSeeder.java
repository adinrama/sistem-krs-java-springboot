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
                        "surya@yahoo.id",
                        "Surya Kertanegara",
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
                        "hidayatul@yahoo.id",
                        "Hidayatul Ulum",
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
                        "hendra@yahoo.id",
                        "Hendra Gunawan",
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
                        "bayu@yahoo.id",
                        "Bayu Rahadian",
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
                        "ajeng@yahoo.id",
                        "Ajeng Sasmito",
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
                        "nisrina@yahoo.id",
                        "Nisrina Ayu Pambudi",
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
