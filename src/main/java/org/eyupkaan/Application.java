package org.eyupkaan;

import org.eyupkaan.model.Student;
import org.eyupkaan.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student stu1 = new Student(33L,"Eyüp Kaan","Özteriş","eypkn.oztrs@gmail.com");

            Student stu2 = new Student();
            stu2.setId(23L);
            stu2.setFirstName("Anıl");
            stu2.setLastName("Düz");
            stu2.setEmail("aduz@gmail.com");

            studentRepository.save(stu1);
            studentRepository.save(stu2);
        };
    }

}
