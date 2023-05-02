package com.codeclan.classroombooking.modules.classes;

import com.codeclan.classroombooking.modules.students.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnoreProperties({"bookings"})
    private Student student;

    public Booking(Lesson lesson, Student student) {
        this.lesson = lesson;
        this.student = student;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
