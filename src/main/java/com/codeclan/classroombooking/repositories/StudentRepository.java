package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
