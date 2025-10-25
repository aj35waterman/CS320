package test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contact.ContactService;
import contact.Contact;
class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");
        contactService.addContact("12346", "albert", "waterman", "1234567890", "abcdefg");
    }

    @Test
    void testReoccuringId() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact("12345", "Albert", "waterman", "1234567890", "abcdefg");
        });
    }

    @Test
    void testDeleteContactId() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        contactService.deleteContact("12345");
    }

    @Test
    void testDeleteContactInvalidId() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("33");
        });
    }

    @Test
    void testUpdateContactInvalidId() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("100", "albert", "waterman", "1234567890", "airborne rd");
        });
    }

    @Test
    void testUpdateContactNullEntries() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", null, null, null, null);
        });
    }

    @Test
    void testUpdateFirstNameTooLong() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "Johnnnnnnnn", "Doe", "1234567890", "abcdefg");
        });
    }

    @Test
    void testUpdateLastNameTooLong() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "John", "Doeeeeeeeee", "1234567890", "abcdefg");
        });
    }

    @Test
    void testUpdatePhoneTooLong() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "John", "Doe", "12345678901", "abcdefg");
        });
    }

    @Test
    void testUpdateAddressTooLong() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "John", "Doe", "1234567890", "abcdefghijklmnopqrstuvwxyzabcde");
        });
    }
    @Test
    void testUpdateContact() {
        ContactService contactService = new ContactService();
        contactService.addContact("12345", "John", "Doe", "1234567890", "abcdefg");
        contactService.updateContact("12345", "Albert", "Maine", "1111111111", "Montana");
        Contact contact = contactService.contact.get("12345");
        Assertions.assertEquals("Albert", contact.getFirstName());
        Assertions.assertEquals("Maine",  contact.getLastName());
        Assertions.assertEquals("1111111111", contact.getPhone());
        Assertions.assertEquals("Montana", contact.getAddress());
    }
}
