package com.codeclan.classroombooking.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "demerits")
public class Demerit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DemeritType demerit;

    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonIgnoreProperties({"demerits"})
    private Student student;

    public Demerit(DemeritType demerit, LocalDate date, Student student) {
        this.demerit = demerit;
        this.date = date;
        this.student = student;
    }

    public Demerit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DemeritType getDemerit() {
        return demerit;
    }

    public void setDemerit(DemeritType demerit) {
        this.demerit = demerit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
