package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentService.Appointment;



class AppointmentTest {
	private String id, description;
	private String tooLongId, tooLongDescription;
	private Date date, pastDate;

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		id = "1234567890";
		description = "The appointment object shall have a required description.";
		date = new Date(2028, Calendar.NOVEMBER,5);
		tooLongId = "1112223334445555666776879947";
		tooLongDescription = "This description is too long for the appointment requirements biut good for testing.";
		pastDate = new Date(0); 
	}
	
	@Test
	void testUpdateAppointmentId() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appt.updateAppointmentId(tooLongId));
	
	}
	
	@Test
	void testGetAppointmentId() {
		Appointment appt = new Appointment(id);
		assertEquals(appt.getAppointmentId().length(), 10);
		assertEquals(id, appt.getAppointmentId());
	}
	
	@Test
	void testUpdateDate() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appt.updateDate(pastDate));
		appt.updateDate(date);
		assertEquals(date, appt.getAppointmentDate());
	}
	
	@Test
	void testUpdateDescription() {
		Appointment appt = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appt.updateDescription(tooLongDescription));
		appt.updateDescription(description);
		assertEquals(description, appt.getDescription());
	}
	
	@Test
	void testGetDescription() {
		Appointment appt = new Appointment(id, date, description);
		assertTrue(appt.getDescription().length()<=50);
		assertEquals(description, appt.getDescription());
	}
}