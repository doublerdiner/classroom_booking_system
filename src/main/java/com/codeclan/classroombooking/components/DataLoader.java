package com.codeclan.classroombooking.components;

import com.codeclan.classroombooking.modules.User;
import com.codeclan.classroombooking.modules.classes.DayType;
import com.codeclan.classroombooking.modules.classes.Lesson;
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
    LessonRepository lessonRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AbsenceRepository absenceRepository;
    @Autowired
    DemeritRepository demeritRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        User user = new User("Aimi", "Barclay", "aimi.barclay1@gmail.com");
        User user2 = new User("Chris", "Barclay", "chris.barclay1@gmail.com");
        User user3 = new User("Jim", "Barclay", "jim.barclay4@gmail.com");
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
        Lesson lesson = new Lesson("Art & Design", DayType.MON, 1, 1, user);
        Lesson lesson2 = new Lesson("History", DayType.MON, 1, 1, user2);
        Lesson lesson3 = new Lesson("Photography", DayType.MON, 2, 1, user);
        lessonRepository.save(lesson);
        lessonRepository.save(lesson2);
        lessonRepository.save(lesson3);
        Student student = new Student("Dale", "Cooper", 1);
        Student student2 = new Student("Laura", "Palmer", 1);
        Student student3 = new Student("Leland", "Palmer", 1);
        Student student4 = new Student("Gordon", "Cole", 1);
        Student student5 = new Student("Audrey", "Horne", 1);
        lesson.saveStudentToLesson(student);
        lesson.saveStudentToLesson(student2);
        lesson.saveStudentToLesson(student3);
        lesson.saveStudentToLesson(student4);
        lesson.saveStudentToLesson(student5);
        student.saveLessonToStudent(lesson);
        student2.saveLessonToStudent(lesson);
        student3.saveLessonToStudent(lesson);
        student4.saveLessonToStudent(lesson);
        student5.saveLessonToStudent(lesson);
        studentRepository.save(student);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        Absence absence = new Absence(AbsenceType.LATE, LocalDate.now(), student);
        Demerit demerit = new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student);
        absenceRepository.save(absence);
        demeritRepository.save(demerit);


    }
}
