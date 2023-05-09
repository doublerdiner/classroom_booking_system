package com.codeclan.classroombooking.controllers;

import com.codeclan.classroombooking.modules.User;
import com.codeclan.classroombooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<User>> getUser(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @RequestBody User user
    ){
        User updateUser = userRepository.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setLessons(user.getLessons());
        userRepository.save(updateUser);
        return new ResponseEntity<>(updateUser, HttpStatus.ACCEPTED);
    }

}
