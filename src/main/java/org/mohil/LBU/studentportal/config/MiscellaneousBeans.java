package org.mohil.LBU.studentportal.config;

import org.mohil.LBU.studentportal.model.Course;
import org.mohil.LBU.studentportal.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MiscellaneousBeans {

    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
      // 	courseRepository.save(new Course("SCSE", "Software computing system engineering", 879f));
     //    courseRepository.save(new Course("ML", "Machine Learning", 665f));
    // courseRepository.save(new Course("PM", "Project Management", 750f));
   // courseRepository.save(new Course("f", "Fiance", 350f));

        };
    }
}