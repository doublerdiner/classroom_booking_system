package com.codeclan.classroombooking.controllers;

import com.codeclan.classroombooking.modules.students.Demerit;
import com.codeclan.classroombooking.repositories.DemeritRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DemeritController {
    @Autowired
    DemeritRepository demeritRepository;

    @GetMapping(value = "/demerits")
    public ResponseEntity<List<Demerit>> getAllDemerits(){
        return new ResponseEntity<>(demeritRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/demerits/{id}")
    public ResponseEntity<Optional<Demerit>> getDemerit(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(demeritRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/demerits")
    public ResponseEntity saveDemerit(
            @RequestBody Demerit demerit
    ){
        demeritRepository.save(demerit);
        return new ResponseEntity(demerit, HttpStatus.CREATED);
    }
    @PutMapping(value = "/demerits/{id}")
    public ResponseEntity<Demerit> updateDemerit(
            @PathVariable Long id,
            @RequestBody Demerit demerit
    ){
        Demerit updateDemerit = demeritRepository.findById(id).get();
        updateDemerit.setDemerit(demerit.getDemerit());
        updateDemerit.setDate(demerit.getDate());
        updateDemerit.setStudent(demerit.getStudent());
        updateDemerit.setNotes(demerit.getNotes());
        demeritRepository.save(updateDemerit);
        return new ResponseEntity<>(updateDemerit, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/demerits/{id}")
    public ResponseEntity<Long> deleteDemerit(
            @PathVariable Long id
    ){
        demeritRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
