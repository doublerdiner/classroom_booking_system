package com.codeclan.classroombooking.controllers;

import com.codeclan.classroombooking.modules.classes.Lesson;
import com.codeclan.classroombooking.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class LessonController {
    @Autowired
    LessonRepository lessonRepository;

    @GetMapping(value = "/lessons")
    public ResponseEntity<List<Lesson>> getAllLessons(){
        return new ResponseEntity<>(lessonRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/lessons/{id}")
    public ResponseEntity<Optional<Lesson>> getLesson(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(lessonRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/lessons")
    public ResponseEntity saveLesson(
            @RequestBody Lesson lesson
    ){
        lessonRepository.save(lesson);
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }
    @PutMapping(value = "/lessons/{id}")
    public ResponseEntity<Lesson> updateLesson(
            @PathVariable Long id,
            @RequestBody Lesson lesson
    ){
        Lesson updateLesson = lessonRepository.findById(id).get();
        updateLesson.setName(lesson.getName());
        updateLesson.setDayType(lesson.getDayType());
        updateLesson.setPeriod(lesson.getPeriod());
        updateLesson.setYearGroup(lesson.getYearGroup());
        updateLesson.setUser(lesson.getUser());
        updateLesson.setStudents(lesson.getStudents());
        lessonRepository.save(updateLesson);
        return new ResponseEntity<>(updateLesson, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/lessons/{id}")
    public ResponseEntity<Long> deleteLesson(
            @PathVariable Long id
    ){
        lessonRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
