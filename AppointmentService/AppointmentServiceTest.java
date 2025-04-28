package test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointmentService.AppointmentService;


class AppointmentServiceTest {
	private String id, description, tooLongDescription;
	private Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		id = "1234567890";
		description = "The appointment object shall have a required description.";
		date = new Date(2038, Calendar.NOVEMBER,5);
		tooLongDescription = "This description is too long for the appointment requirements biut good for testing.";
		pastDate = new Date(0);
	}
	@Test
	void testNewAppointment() {
		AppointmentService service = new AppointmentService();
		
		service.newAppointment();
		assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
		assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(0).getDescription());
	}
	@Test
	void testNewAppointmentId() {
		AppointmentService service = new AppointmentService();
		service.newAppointment(date);
		assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
		assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(1).getDescription());
	}
	@Test
	void testNewAppointmentDate () {
		AppointmentService service = new AppointmentService();
		service.newAppointment(date, description);
		assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
		assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(description, service.getAppointmentList().get(2).getDescription());
		
	}
	@Test
	void testNewAppointmentDescription() {
		AppointmentService service = new AppointmentService();
		service.newAppointment(date, description);
		assertEquals(service.getAppointmentList().get(0).getAppointmentId(),
				service.getAppointmentList().get(1).getAppointmentId());
		assertEquals(service.getAppointmentList().get(0).getAppointmentDate(),
				service.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(service.getAppointmentList().get(1).getDescription(),
				service.getAppointmentList().get(2).getDescription());
	}
	@Test
	void testNewAppointmentService() {
		AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class,
				() -> service.newAppointment(pastDate));
	}
		@Test
		void testAppointment() {
			AppointmentService service = new AppointmentService();
		assertThrows(IllegalArgumentException.class,
				() -> service.newAppointment(date, tooLongDescription));
	}
	
	
}