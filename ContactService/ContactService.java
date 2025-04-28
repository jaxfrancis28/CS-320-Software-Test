package contacts;

import java.util.Vector;
import java.util.Random;

//Class for managing contacts
public class ContactService {
	
	//Vector to store contacts
	private Vector<Contact> myContacts = new Vector<Contact>();
	
	//Number of contacts counter
	private int numContacts = 0;
	
	//Getter for number of contacts
	public int numContacts() {
		return numContacts;
	}
	
	//Getter for number lists of contacts
		public Vector<Contact> getContactList(){
			return myContacts;
		}
		
		//Add contacts list function
		public void addContact(String contactID, String firstName, String lastName, String phoneNumber, String contactAddress) {
			Contact newContact = new Contact(contactID, firstName, lastName, phoneNumber, contactAddress);
			
			myContacts.add(newContact);
			
			numContacts++;
		
		}
		
		public void addContact(Contact contact) {
			//add the contact to the list of contacts
			myContacts.add(contact);
			numContacts++;
		}
		
		public void removeContact(String contactID) {
			
			if (contactID == null || contactID.length() > 10) {
				throw new IllegalArgumentException("Invalid contact ID.");
			}
			

			if (myContacts.isEmpty()) {
				throw new IllegalArgumentException("No saved contacts.");
				
			}
			int index = -1;
			
			for(Contact c: myContacts) {
				if (c.getcontactId() == contactID) {
					index = myContacts.indexOf(c);
				}
			}
			
			if (index == -1) {
				System.out.println("Not found");
				return;	
		}
			else {
				
				myContacts.remove(index);
				numContacts--;
				System.out.println("Removed.");
			}
		}
			
		
		public void removeContact(Contact contact) {
			myContacts.remove(contact);
			numContacts --;
		}
		
		public void updateContact(String ID, String update, int slection){
			
			if (ID == null || ID.length() > 10) {
				throw new IllegalArgumentException("Invalid contact ID.");
			}
			

			if (myContacts.isEmpty()) {
				throw new IllegalArgumentException("No saved contacts.");
				
			}
			int index = -1;
			
			for(Contact c: myContacts) {
				if (c.getcontactId() == ID) {
					index = myContacts.indexOf(c);
				}
			}
			
			if (index == -1) {
				System.out.println("Not found");
				return;
			}
			Contact updatedContact = myContacts.get(index);
			switch(numContacts) {
			
				case 1:{
					updatedContact.setFirstName(update);
					break;
				}
				case 2:{
					updatedContact.setLastName(update);
					break;
				}
				case 3:{
					updatedContact.setFirstName(update);
					break;
				}
				case 4:{
					updatedContact.setFirstName(update);
					break;
				}
				default:{
					removeContact(myContacts.elementAt(index));
					addContact(updatedContact);
					
				}
				
			}
			
		}
		
		public void updateContacts(String ID, String firstName, String lastName, String phoneNumber, String contactAddress) {
			if (ID == null || ID.length() > 10) {
				throw new IllegalArgumentException("Invalid contact ID.");	
			}
			if (myContacts.isEmpty()) {
				throw new IllegalArgumentException("No contacts.");	
			}
			
			int index = -1;
			
			for(Contact c: myContacts) {
				if (c.getcontactId() == ID) {
					index = myContacts.indexOf(c);
				}
				
			}
				
				
			
			if (index == -1) {
				System.out.println("Not found");
				return;
			}
			
			Contact tempContact = myContacts.get(index);
			
			tempContact.setFirstName(firstName);
			tempContact.setFirstName(lastName);
			tempContact.setFirstName(phoneNumber);
			tempContact.setFirstName(contactAddress);
			
			myContacts.remove(index);
			myContacts.add(tempContact);
			
			}
			
			public String generateUniqueId() {
				Random rand = new Random();
				int newID = rand.nextInt(1234567890);
				String uniqueId = Integer.toString(newID);
				
				for (Contact c: myContacts) {
					while(c.getcontactId() == uniqueId) {
						newID = rand.nextInt(1234567890);
						uniqueId = Integer.toString(newID);
					}
				}
				
				System.out.println("New Contact ID created: " + uniqueId);
				return uniqueId;
				
		}
}

		
	
	
	