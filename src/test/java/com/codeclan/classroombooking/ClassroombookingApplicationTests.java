package com.codeclan.classroombooking;

import com.codeclan.classroombooking.modules.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClassroombookingApplicationTests {
	private User user;
	private Classroom classroom;
	private Booking booking;
	private Student student;
	private Demerit demerit;

	@Test
	void contextLoads() {
	}
	@Test
	public void userHasDetails(){
		user = new User("Aimi", "Barclay");
		assertEquals("Aimi", user.getFirstName());
		assertEquals("Barclay", user.getLastName());
		assertEquals(0, user.getClassrooms().size());
	}
	@Test
	public void classroomHasDetails(){
		user = new User("Aimi", "Barclay");
		classroom = new Classroom("1A", DayType.MON, 1, user);
		assertEquals("1A", classroom.getName());
		assertEquals("Monday", classroom.getDay().formatted());
		assertEquals(1, classroom.getPeriod());
		assertEquals("Aimi", classroom.getUser().getFirstName());
	}
	@Test
	public void studentHasDetails(){
		student = new Student("Dale", "Cooper", 1);
		assertEquals("Dale", student.getFirstName());
		assertEquals("Cooper", student.getLastName());
		assertEquals(1, student.getYear());
		assertEquals(0, student.getBookings().size());
		assertEquals(0, student.getDemerits().size());
	}
	@Test
	public void bookingHasDetails(){
		user = new User("Aimi", "Barclay");
		classroom = new Classroom("1A", DayType.MON, 1, user);
		student = new Student("Dale", "Cooper", 1);
		booking = new Booking(classroom, student);
		assertEquals("1A", booking.getClassroom().getName());
		assertEquals("Dale", booking.getStudent().getFirstName());
	}
	@Test
	public void demeritHasDetails(){
		student = new Student("Dale", "Cooper", 1);
		demerit = new Demerit(DemeritType.FIRST_WARNING, LocalDate.of(2023, 5, 2), student);
		assertEquals("First Warning", demerit.getDemerit().formatted());
		assertEquals(LocalDate.parse("2023-05-02"),  demerit.getDate());
		assertEquals("Dale", demerit.getStudent().getFirstName());
	}

}
