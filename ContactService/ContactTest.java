package test;

import org.junit.jupiter.api.Test;

import contacts.Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

//Test class for Contact creation
public class ContactTest {
	
	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
	@Test
	void testContactId() {
		Contact contact = new Contact("123456", "David", "Plies", "5432109876", "123 Main st");
		assertTrue(contact.getcontactId().equals("123456"));
	}

	@Test
	void testContactFirstName() {
		Contact contact = new Contact("123456", "David", "Plies", "5432109876", "123 Main st");
		assertTrue(contact.getFirstName().equals("David"));
	}
	@Test
	void testContactLastName() {
		Contact contact = new Contact("123456", "David", "Plies", "5432109876", "123 Main st");
		assertTrue(contact.getLastName().equals("Plies"));
	}
		
	@Test
	void testContactNumber() {
		Contact contact = new Contact("123456", "David", "Plies", "5432109876", "123 Main st");
		assertTrue(contact.getNumber().equals("5432109876"));
	}
	@Test
	void testContactAddress() {
		Contact contact = new Contact("123456", "David", "Plies", "5432109876", "123 Main st");
		assertTrue(contact.getAddress().equals("123 Main St"));
	}

}

	
	
	