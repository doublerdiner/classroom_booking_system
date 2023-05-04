package com.codeclan.classroombooking.repositories;

import com.codeclan.classroombooking.modules.classes.DayType;
import com.codeclan.classroombooking.modules.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsByBookingsLessonUserFirstNameAndBookingsLessonUserLastNameAndBookingsLessonDayTypeAndBookingsLessonPeriod(String userFirstName, String userLastName, DayType dayType, int period);
}
