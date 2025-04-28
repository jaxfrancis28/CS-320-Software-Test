package test;

import org.junit.jupiter.api.Test;

import contacts.Contact;
import contacts.ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class ContactServiceTest {

	@Test
	 void testAddContact() {
		ContactService contactService = new ContactService();
		String testID = contactService.generateUniqueId();
		Contact contact = new Contact(testID, "Bob", "Ross","1234567890", "123 Joe Ave");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactList().isEmpty());
		
	}
	
	@Test
	 void testRemoveContact() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("123456", "Bob", "Ross","0987654321", "123 Joe Ave");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("");
		});
	}
	
	
	@Test
	 void testUpdateContactError() {
		ContactService contactService = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456","John",1);
		});
	}
		@Test
		 void testUpdateContactErrors() {
			ContactService contactService = new ContactService();
		Contact contact = new Contact("123456", "Bob", "Ross","0987654321", "123 Joe Ave");
		contactService.addContact(contact);
		
		assertTrue(!contactService.getContactList().isEmpty());
	}
			
			
			
		@Test
		void testupdateContact() {
			ContactService contactService = new ContactService();
			Contact contact = new Contact("123456", "Bob", "Ross","0987654321", "123 Joe Ave");
			contactService.addContact(contact);
			assertTrue(!contactService.getContactList().isEmpty());
			
			
			}
		}
		
			
			
				
		
		
		
		
	