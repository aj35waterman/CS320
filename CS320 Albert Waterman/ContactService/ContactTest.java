package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contact.Contact;
class ContactTest {

	@Test
	void testContactValid() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "abcdefg");
        assertTrue(contact.getContactId().equals("12345"));
        assertTrue(contact.getFirstName().equals("John"));
        assertTrue(contact.getLastName().equals("Doe"));
        assertTrue(contact.getPhone().equals("1234567890"));
        assertTrue(contact.getAddress().equals("abcdefg"));
    }// testing nulls 
	@Test
    void testNullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "abcdefg")
        );
    } 

    @Test
    void testNullFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", null, "Doe", "1234567890", "abcdefg")
        ); 
    }

    @Test
    void testNullLastName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", null, "1234567890", "abcdefg")
        );
    }

    @Test
    void testNullPhone() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", null, "abcdefg")
        );
    }

    @Test
    void testNullAddress() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "1234567890", null)
        );
    }//length of ID
    @Test
    void testIdTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345678901", "John", "Doe", "1234567890", "abcdefg") 
        );
    }

    @Test //first name greater then 10
    void testFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "abcdefghijk", "Doe", "1234567890", "abcdefg")
        );
    }

    @Test //last name greater then 10
    void testLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "abcdefghijk", "1234567890", "abcdefg")
        );
    }

    @Test
    void testPhoneNot10digits() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "12345", "abcdefg")
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "12345678901", "abcdefg")
        );
    }

    @Test//address greater then 10
    void testAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345", "John", "Doe", "1234567890", "abcdefghijklmnopqrstuvwxyzabcde") 
        );
    }
    @Test
    void testSettersUpdateValues() {
        Contact contact = new Contact("33", "Aj", "Man", "1234567890", "yeallowstone");
        contact.setFirstName("Albert");
        contact.setLastName("Maine");
        contact.setPhone("1111111111");
        contact.setAddress("Montana");
        assertEquals("Albert", contact.getFirstName());
        assertEquals("Maine", contact.getLastName());
        assertEquals("1111111111", contact.getPhone());
        assertEquals("Montana", contact.getAddress());
    }

    @Test
    void testSetFirstNameTooLongThrows() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "abcdefg");
        assertThrows(IllegalArgumentException.class, () ->
            contact.setFirstName("abcdefghijk") // 11 chars
        );
    }

    @Test
    void testSetLastNameTooLongThrows() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "abcdefg");
        assertThrows(IllegalArgumentException.class, () ->
            contact.setLastName("abcdefghijk") // 11 chars
        );
    }

    @Test
    void testSetPhoneNonDigitsThrows() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "abcdefg");
        assertThrows(IllegalArgumentException.class, () ->
            contact.setPhone("12345678a0") // 10 chars but not all digits
        );
    }

    @Test
    void testSetAddressTooLongThrows() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "abcdefg");
        assertThrows(IllegalArgumentException.class, () ->
            contact.setAddress("abcdefghijklmnopqrstuvwxyzabcde") // 31 chars
        );
    }
}

