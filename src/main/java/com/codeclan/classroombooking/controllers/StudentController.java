package com.codeclan.classroombooking.controllers;

import com.codeclan.classroombooking.modules.classes.DayType;
import com.codeclan.classroombooking.modules.students.Student;
import com.codeclan.classroombooking.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getAllStudents(
            @RequestParam(name = "userfirstname", required = false) String firstName,
            @RequestParam(name = "userlastname", required = false) String lastName,
            @RequestParam(name = "day", required = false) String day,
            @RequestParam(name = "period", required = false) Integer period
    ){
        if(firstName != null && lastName != null && day != null && period != null){
            DayType dayType = DayType.convertToDayType(day);
            return new ResponseEntity<>(studentRepository.findStudentsByBookingsLessonUserFirstNameAndBookingsLessonUserLastNameAndBookingsLessonDayTypeAndBookingsLessonPeriod(firstName, lastName, dayType, period), HttpStatus.OK);
        }
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Optional<Student>> getStudent(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/students")
    public ResponseEntity saveStudent(
            @RequestBody Student student
    ){
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    @PutMapping(value = "/students/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ){
        Student updateStudent = studentRepository.findById(id).get();
        updateStudent.setFirstName(student.getFirstName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setStudentYear(student.getStudentYear());
        updateStudent.setBookings(student.getBookings());
        updateStudent.setDemerits(student.getDemerits());
        updateStudent.setAbsences(student.getAbsences());
        updateStudent.setDemeritFlag(student.isDemeritFlag());
        updateStudent.setAbsenceFlag(student.isAbsenceFlag());
        updateStudent.setNotes(student.getNotes());
        studentRepository.save(updateStudent);
        return new ResponseEntity<>(updateStudent, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<Long> deleteStudent(
            @PathVariable Long id
    ){
        studentRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
