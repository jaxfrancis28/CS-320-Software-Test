package contacts;


//Define the Contact class
public class Contact {
	//Private member variables for contact details
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String contactAddress;

//Constructor to initialize contact details
	public Contact(String id, String fName, String lName, String pNumber, String conAddress ) {
		if (id == null || id.length()> 10) {
			throw new IllegalArgumentException("Invaild contact ID");
		}
		if (id == null || firstName.length()> 10) {
			throw new IllegalArgumentException("Invaild first name");
		}
		if (id == null || lastName.length()> 10) {
			throw new IllegalArgumentException("Invaild last name");
		}
		if (id == null || phoneNumber.length()> 10) {
			throw new IllegalArgumentException("Invaild number");
		}
		if (id == null || contactAddress.length()> 30) {
			throw new IllegalArgumentException("Invaild address");
		}
		
		this.contactID = id;
		this.firstName = fName;
		this.lastName = lName;
		this.phoneNumber = pNumber;
		this.contactAddress = conAddress;
		
	}
	
	//Getter methods for accessing contact details
	
	//Method to get contact ID
	public String getcontactId( ) {
		return this.contactID;
	}
	//Method to get first name
		public String getFirstName( ) {
			return this.firstName;
		}
		//Method to get last name
		public String getLastName( ) {
			return this.lastName;
		}
		//Method to get phone number
		public String getNumber( ) {
			return this.phoneNumber;
		}
		//Method to get address
		public String getAddress( ) {
			return this.contactAddress;
		}
		
		public void setContactId(String newId) {
			if(newId == null || newId.length() > 10) {
				throw new IllegalArgumentException("Invalid contact ID");
			}
			
			contactID = newId;
		}
		
		
		public void setFirstName(String newFirstName) {
			if(newFirstName == null || newFirstName.length() > 10) {
				throw new IllegalArgumentException("Invalid first name");
			}
			
			firstName = newFirstName;
		}
			
			public void setLastName(String newLastName) {
				if(newLastName == null || newLastName.length() > 10) {
					throw new IllegalArgumentException("Invalid last name");
				}
				
				lastName = newLastName;
			}
				public void setNumber(String newNumber) {
					if(newNumber == null || newNumber.length() > 10) {
						throw new IllegalArgumentException("Invalid number");
					}
					
					phoneNumber = newNumber;
					
				}
					public void setAddress(String newAddress) {
						if(newAddress == null || newAddress.length() > 10) {
							throw new IllegalArgumentException("Invalid address");
						}
						
						contactAddress = newAddress;
					}

}



		
	
	
