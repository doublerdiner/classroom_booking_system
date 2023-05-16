package com.codeclan.classroombooking;

import com.codeclan.classroombooking.modules.*;
import com.codeclan.classroombooking.modules.classes.Lesson;
import com.codeclan.classroombooking.modules.classes.DayType;
import com.codeclan.classroombooking.modules.students.*;
import com.codeclan.classroombooking.repositories.AbsenceRepository;
import com.codeclan.classroombooking.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClassroombookingApplicationTests {
	private User user;
	private Lesson lesson;
	private Student student;
	private Demerit demerit;
	private Absence absence;

	@Test
	void contextLoads() {
	}
	@Test
	public void userHasDetails(){
		user = new User("Aimi", "Barclay", "aimi.barclay1@gmail.com");
		assertEquals("Aimi", user.getFirstName());
		assertEquals("Barclay", user.getLastName());
		assertEquals("aimi.barclay1@gmail.com", user.getEmail());
		assertEquals(0, user.getLessons().size());
	}
	@Test
	public void lessonHasDetails(){
		user = new User("Aimi", "Barclay", "aimi.barclay1@gmail.com");
		lesson = new Lesson("Art & Design", DayType.MON, 1, 1, user);
		assertEquals("Art & Design", lesson.getName());
		assertEquals("Monday", lesson.getDayType().formatted());
		assertEquals(1, lesson.getPeriod());
		assertEquals("Aimi", lesson.getUser().getFirstName());
	}
	@Test
	public void studentHasDetails(){
		student = new Student("Dale", "Cooper", 1);
		assertEquals("Dale", student.getFirstName());
		assertEquals("Cooper", student.getLastName());
		assertEquals(1, student.getStudentYear());
		assertEquals(0, student.getLessons().size());
		assertEquals(0, student.getDemerits().size());
	}
	@Test
	public void demeritHasDetails(){
		student = new Student("Dale", "Cooper", 1);
		demerit = new Demerit(DemeritType.FIRST_WARNING, LocalDate.of(2023, 5, 2), student);
		assertEquals("First Warning", demerit.getDemerit().formatted());
		assertEquals(LocalDate.parse("2023-05-02"),  demerit.getDate());
		assertEquals("Dale", demerit.getStudent().getFirstName());
		assertEquals(null, demerit.getNotes());
	}
	@Test
	public void absenceHasDetails(){
		student = new Student("Dale", "Cooper", 1);
		absence = new Absence(AbsenceType.LATE, LocalDate.now(), student);
		assertEquals("Late", absence.getAbsence().formatted());
		assertEquals(LocalDate.parse("2023-05-09"),  absence.getDate());
		assertEquals("Dale", absence.getStudent().getFirstName());
		assertEquals(null, absence.getNotes());
	}
	@Test
	public void checkStudentAttendance(){
		student = new Student("Dale", "Cooper", 1);
		student.checkStudentAbsence();
		assertEquals(false, student.isAbsenceFlag());
		student.addAbsence(new Absence(AbsenceType.LATE, LocalDate.now(), student));
		student.addAbsence(new Absence(AbsenceType.LATE, LocalDate.now(), student));
		student.addAbsence(new Absence(AbsenceType.LATE, LocalDate.now(), student));
		student.addAbsence(new Absence(AbsenceType.LATE, LocalDate.now(), student));
		student.addAbsence(new Absence(AbsenceType.LATE, LocalDate.now(), student));
		student.checkStudentAbsence();
		assertEquals(true, student.isAbsenceFlag());

	}
	@Test
	public void checkStudentDemerits(){
		student = new Student("Dale", "Cooper", 1);
		student.checkStudentDemerit();
		assertEquals(false, student.isDemeritFlag());
		student.addDemerit(new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student));
		student.addDemerit(new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student));
		student.addDemerit(new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student));
		student.addDemerit(new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student));
		student.addDemerit(new Demerit(DemeritType.FIRST_WARNING, LocalDate.now(), student));
		student.checkStudentDemerit();
		assertEquals(true, student.isDemeritFlag());

	}

}
