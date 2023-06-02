package com.codeclan.classroombooking.modules.students;

import com.codeclan.classroombooking.modules.classes.Lesson;
import com.codeclan.classroombooking.modules.misc.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

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
    @Column(name = "student_year")
    private int studentYear;

    @ManyToMany
    @JsonIgnoreProperties({"students"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "lessons_students",
            joinColumns = {
                    @JoinColumn(
                            name = "student_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "lesson_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Lesson> lessons;

    @JsonIgnoreProperties({"student"})
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Demerit> demerits;
    @JsonIgnoreProperties({"student"})
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Absence> absences;
    @Column(name = "demerit_flag")
    private boolean demeritFlag;
    @Column(name="absence_flag")
    private boolean absenceFlag;
    private String notes;

    public Student(String firstName, String lastName, int studentYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentYear = studentYear;
        this.lessons = new ArrayList<>();
        this.demerits = new ArrayList<>();
        this.absences = new ArrayList<>();
        this.demeritFlag = false;
        this.absenceFlag = false;
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

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Demerit> getDemerits() {
        return demerits;
    }

    public void setDemerits(List<Demerit> demerits) {
        this.demerits = demerits;
    }

    public List<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(List<Absence> absences) {
        this.absences = absences;
    }

    public boolean isDemeritFlag() {
        return demeritFlag;
    }

    public void setDemeritFlag(boolean demeritFlag) {
        this.demeritFlag = demeritFlag;
    }

    public boolean isAbsenceFlag() {
        return absenceFlag;
    }

    public void setAbsenceFlag(boolean absenceFlag) {
        this.absenceFlag = absenceFlag;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void saveLessonToStudent(Lesson lesson){
        this.lessons.add(lesson);
    }

    public boolean checkStudentAbsence() {
        int total = 0;
        for(Absence absence : this.absences){
            if(Date.threeMonthsAgo().compareTo(absence.getDate()) <= 0){
                total += 1;
            }
        }
        if(total >= 5){
            setAbsenceFlag(true);
            return true;
        }
        setAbsenceFlag(false);
        return false;
    }public boolean checkStudentDemerit() {
        int total = 0;
        for(Demerit demerit : this.demerits){
            if(Date.threeMonthsAgo().compareTo(demerit.getDate()) <= 0){
                total += 1;
            }
        }
        if(total >= 5){
            setDemeritFlag(true);
            return true;
        }
        setDemeritFlag(false);
        return false;
    }

    public void addAbsence(Absence absence) {
        this.absences.add(absence);
    }

    public void addDemerit(Demerit demerit) {
        this.demerits.add(demerit);
    }
}
