package com.codeclan.classroombooking.controllers;

import com.codeclan.classroombooking.modules.students.Absence;
import com.codeclan.classroombooking.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
public class AbsenceController {
    @Autowired
    AbsenceRepository absenceRepository;

    @GetMapping(value = "/absences")
    public ResponseEntity<List<Absence>> getAllAbsences(){
        return new ResponseEntity<>(absenceRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/absences/{id}")
    public ResponseEntity<Optional<Absence>> getAbsence(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(absenceRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/absences")
    public ResponseEntity saveAbsence(
            @RequestBody Absence absence
    ){
        System.out.println(absence);
        absenceRepository.save(absence);
        return new ResponseEntity<>(absence, HttpStatus.CREATED);
    }
    @PutMapping(value = "/absences/{id}")
    public ResponseEntity<Absence> updateAbsence(
            @PathVariable Long id,
            @RequestBody Absence absence
    ){
        Absence updateAbsence = absenceRepository.findById(id).get();
        updateAbsence.setAbsenceType(absence.getAbsenceType());
        updateAbsence.setDate(absence.getDate());
        updateAbsence.setStudent(absence.getStudent());
        updateAbsence.setNotes(absence.getNotes());
        absenceRepository.save(updateAbsence);
        return new ResponseEntity<>(absence, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/absences/{id}")
    public ResponseEntity<Long> deleteAbsence(
            @PathVariable Long id
    ){
        absenceRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
