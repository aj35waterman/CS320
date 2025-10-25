
package contact;


public class Contact {
	private final String contactId; //private final because it is not updatable     
    private String firstName;     
    private String lastName;      
    private String phone;         
    private String address;      

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
    	if(contactId == null || contactId.length() > 10) {
    		throw new IllegalArgumentException("Invalid id");
    	}
    	if(firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("Invalid first name");
    	}
    	if(lastName == null || lastName.length() > 10) {
    		throw new IllegalArgumentException("Invalid last name");
    	}
    	if(phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
    		throw new IllegalArgumentException("Phone number needs to be 10 numbers");
    	}
    	if(address == null || address.length() > 30) {
    		throw new IllegalArgumentException("Invalid address");
    	}
    	this.contactId = contactId;
    	this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
    //creating getters
    public String getContactId() { 
    	return contactId; 
    }
    public String getFirstName() { 
    	return firstName; 
    }
    public String getLastName() {
    	return lastName; 
    }
    
    public String getPhone() { 
    	return phone; 
    }
    public String getAddress() { 
    	return address; 
    }
    // creating setters with same rules
    public void setFirstName(String firstName) {
    	if(firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("Invalid first name");
    	}
    	this.firstName = firstName;
    }
    public void setLastName(String lastName) {
    	if(lastName == null || lastName.length() > 10) {
    		throw new IllegalArgumentException("Invalid last name");
    	}
    	this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number needs to be 10 numbers");
        }
        this.phone = phone;
    }
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    } 
}