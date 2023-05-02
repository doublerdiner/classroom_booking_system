package com.codeclan.classroombooking.components;

import com.codeclan.classroombooking.modules.*;
import com.codeclan.classroombooking.modules.classes.Booking;
import com.codeclan.classroombooking.modules.classes.Lesson;
import com.codeclan.classroombooking.modules.classes.DayType;
import com.codeclan.classroombooking.modules.students.*;
import com.codeclan.classroombooking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LessonRepository classroomRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    DemeritRepository demeritRepository;
    @Autowired
    AbsenceRepository absenceRepository;

    public DataLoader() {
    }
    public void run(ApplicationArguments args){
        User user = new User("Aimi", "Barclay");
        userRepository.save(user);
        Lesson classroom = new Lesson("Art & Design", DayType.MON, 1, 1, user);
        classroomRepository.save(classroom);
        Student student1 = new Student("Dale", "Cooper", 1);
        Student student2 = new Student("Laura", "Palmer", 1);
        Student student3 = new Student("Gordon", "Cole", 1);
        Student student4 = new Student("Leland", "Palmer", 1);
        Booking booking1 = new Booking(classroom, student1);
        Booking booking2 = new Booking(classroom, student2);
        Booking booking3 = new Booking(classroom, student3);
        Booking booking4 = new Booking(classroom, student4);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        Demerit demerit = new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student1);
        demeritRepository.save(demerit);
        Absence absence = new Absence(AbsenceType.LATE, LocalDate.now(), student1);
        absenceRepository.save(absence);

    }

}
