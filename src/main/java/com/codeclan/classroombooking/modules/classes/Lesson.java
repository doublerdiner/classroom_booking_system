package com.codeclan.classroombooking.modules.classes;

import com.codeclan.classroombooking.modules.User;
import com.codeclan.classroombooking.modules.students.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "day_type")
    private DayType dayType;

    private int period;
    @Column(name = "year_group")
    private int yearGroup;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"lessons"})
    private User user;

    @ManyToMany
    @JsonIgnoreProperties({"lessons"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "lessons_students",
            joinColumns = {
                    @JoinColumn(
                            name = "lesson_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "student_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Student> students;

    public Lesson(String name, DayType dayType, int period, int yearGroup, User user) {
        this.name = name;
        this.dayType = dayType;
        this.period = period;
        this.yearGroup = yearGroup;
        this.user = user;
        this.students = new ArrayList<>();
    }

    public Lesson() {
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

    public int getYearGroup() {
        return yearGroup;
    }

    public void setYearGroup(int yearGroup) {
        this.yearGroup = yearGroup;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void saveStudentToLesson(Student student){
        this.students.add(student);
    }
}
