package com.codeclan.classroombooking.controllers;

import com.codeclan.classroombooking.modules.classes.Booking;
import com.codeclan.classroombooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Optional> getBooking(
            @PathVariable Long id
    ){
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping(value = "/bookings")
    public ResponseEntity saveBooking(
            @RequestBody Booking booking
    ){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Long id,
            @RequestBody Booking booking
    ){
        Booking updateBooking = bookingRepository.findById(id).get();
        updateBooking.setLesson(booking.getLesson());
        updateBooking.setStudent(booking.getStudent());
        bookingRepository.save(updateBooking);
        return new ResponseEntity<>(updateBooking, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "bookings/{id}")
    public ResponseEntity<Long> deleteBooking(
            @PathVariable Long id
    ){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
