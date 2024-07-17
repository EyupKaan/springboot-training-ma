package org.eyupkaan.service;

import jakarta.transaction.Transactional;
import org.eyupkaan.model.Student;
import org.eyupkaan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class StudentService {

    // DAO
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        /*
        Otional döndüğü için .get() kullanmak gerekir.
        bu şekilde de kullanımları vardır.
            return studentRepository.findById(id).get();

         */
        return studentRepository.findById(id).orElse(null);
        // return studentRepository.getReferenceById(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Student currentStudent) {
        return Optional.of(studentRepository.save(currentStudent));
    }

    public String deleteStudent(Long id) {
        Student studentInfo = studentRepository.getReferenceById(id);
        if(studentInfo != null){
            studentRepository.deleteById(id);
            return " '" + studentInfo.getFirstName() + " " + studentInfo.getLastName() +
                    "' kullanıcı başarı bir şekilde silindi";
        }else{
            return "ERROR: \n" + id + "numaralı id ile kullanıcı bulunamadı";
        }
    }
}
