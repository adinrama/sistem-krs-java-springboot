package com.adinrama.springboot.project1.course.seeder;

import com.adinrama.springboot.project1.course.model.Course;
import com.adinrama.springboot.project1.course.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Profile("dev")
public class CourseSeeder implements CommandLineRunner {

    @Autowired
    private CourseRepo courseRepository;

    @Override
    public void run(String... args) {
        if (courseRepository.count() > 0) {
            return;
        }

        List<Course> courses = List.of(
                new Course(
                        null,
                        "C2601357",
                        "Web Programming with Java SpringBoot",
                        "GENAP",
                        3,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null,
                        null
                ),
                new Course(
                        null,
                        "C2602357",
                        "Mobile Programming with Flutter",
                        "GENAP",
                        3,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null,
                        null
                ),
                new Course(
                        null,
                        "C2603357",
                        "Data Analysis with Python",
                        "GANJIL",
                        2,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null,
                        null
                ),
                new Course(
                        null,
                        "C2604357",
                        "Data Wrangling with Python",
                        "GANJIL",
                        2,
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null,
                        null
                )
        );

        courseRepository.saveAll(courses);
        System.out.println("✔ Course seeder executed");
    }
}
