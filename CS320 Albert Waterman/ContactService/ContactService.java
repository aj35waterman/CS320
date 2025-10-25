package contact;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    
    public Map<String, Contact> contact = new HashMap<>(); //HashMap creation

    // Add a new contact check for ID and if it already exist
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contact.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contact.put(contactId, newContact);//create new contact object for map
    }

    // Delete a contact with ID
    public void deleteContact(String contactId) { 
        if (contact.remove(contactId) == null) {
            throw new IllegalArgumentException("ID does not exist");
        }
    }

    // Update a contact with ID
    public void updateContact(String contactId, String newFirstName, String newLastName, String newPhone, String newAddress) {
        Contact foundContact = contact.get(contactId);

        if (foundContact == null) {
            throw new IllegalArgumentException("ID not found");
        }

        if (newFirstName == null && newLastName == null && newPhone == null && newAddress == null) {
            throw new IllegalArgumentException("Cannot be null");
        }

        // Validation of inputs
        if (newFirstName != null && newFirstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (newLastName != null && newLastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (newPhone != null && (newPhone.length() != 10 || !newPhone.matches("\\d{10}"))) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (newAddress != null && newAddress.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        if (newFirstName != null) foundContact.setFirstName(newFirstName);//only updates the fields that don't input null
        if (newLastName  != null) foundContact.setLastName(newLastName);
        if (newPhone     != null) foundContact.setPhone(newPhone);
        if (newAddress   != null) foundContact.setAddress(newAddress);
    }
}
        

        
        
        
    
   


    


