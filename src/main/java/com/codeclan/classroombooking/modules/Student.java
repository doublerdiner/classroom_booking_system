package com.codeclan.classroombooking.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int year;
    @JsonIgnoreProperties({"student"})
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Booking> bookings;
    @JsonIgnoreProperties({"student"})
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Demerit> demerits;
    @Column(name = "demerit_flag")
    private boolean demeritFlag;

    public Student(String firstName, String lastName, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.bookings = new ArrayList<>();
        this.demerits = new ArrayList<>();
        this.demeritFlag = false;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Demerit> getDemerits() {
        return demerits;
    }

    public void setDemerits(List<Demerit> demerits) {
        this.demerits = demerits;
    }

    public boolean isDemeritFlag() {
        return demeritFlag;
    }

    public void setDemeritFlag(boolean demeritFlag) {
        this.demeritFlag = demeritFlag;
    }
}
