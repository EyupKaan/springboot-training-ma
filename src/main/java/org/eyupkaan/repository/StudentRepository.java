package org.eyupkaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.eyupkaan.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
