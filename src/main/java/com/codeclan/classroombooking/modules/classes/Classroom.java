package com.codeclan.classroombooking.modules.classes;

import com.codeclan.classroombooking.modules.User;
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

    @Column(name = "day_type")
    private DayType dayType;

    private int period;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"classrooms"})
    private User user;
    @JsonIgnoreProperties({"classroom"})
    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Classroom(String name, DayType dayType, int period, User user) {
        this.name = name;
        this.dayType = dayType;
        this.period = period;
        this.user = user;
        this.bookings = new ArrayList<>();
    }

    public Classroom() {
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

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
