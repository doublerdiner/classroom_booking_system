package com.codeclan.classroombooking.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private DayType day;

    private int period;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"classrooms"})
    private User user;
    @JsonIgnoreProperties({"classroom"})
    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Classroom(String name, DayType day, int period, User user) {
        this.name = name;
        this.day = day;
        this.period = period;
        this.user = user;
        this.bookings = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayType getDay() {
        return day;
    }

    public void setDay(DayType day) {
        this.day = day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
