package contacts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        assertTrue(service.addContact(contact));
        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testAddContactDuplicateIdFails() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Elm Street");

        assertTrue(service.addContact(contact1));
        assertFalse(service.addContact(contact2)); // duplicate ID
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        assertTrue(service.deleteContact("1"));
        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteContactNotFound() {
        assertFalse(service.deleteContact("999"));
    }

    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        assertTrue(service.updateFirstName("1", "Jane"));
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        assertTrue(service.updateLastName("1", "Smith"));
        assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        assertTrue(service.updatePhone("1", "0987654321"));
        assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        assertTrue(service.updateAddress("1", "456 Elm Street"));
        assertEquals("456 Elm Street", service.getContact("1").getAddress());
    }

    @Test
    public void testUpdateNonExistingContactReturnsFalse() {
        assertFalse(service.updateFirstName("999", "Nope"));
        assertFalse(service.updateLastName("999", "Nope"));
        assertFalse(service.updatePhone("999", "1234567890"));
        assertFalse(service.updateAddress("999", "Nowhere"));
    }
}
