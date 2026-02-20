package contacts;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;



public class ContactTest {



    @Test

    public void testValidContactCreation() {

        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");

        assertEquals("12345", contact.getContactId());

        assertEquals("John", contact.getFirstName());

        assertEquals("Doe", contact.getLastName());

        assertEquals("1234567890", contact.getPhone());

        assertEquals("123 Main Street", contact.getAddress());

    }



    @Test

    public void testContactIdTooLongThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");

        });

    }



    @Test

    public void testFirstNameNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact("12345", null, "Doe", "1234567890", "123 Main Street");

        });

    }



    @Test

    public void testLastNameNullThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact("12345", "John", null, "1234567890", "123 Main Street");

        });

    }



    @Test

    public void testPhoneInvalidLengthThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact("12345", "John", "Doe", "12345", "123 Main Street");

        });

    }



    @Test

    public void testPhoneNonDigitsThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact("12345", "John", "Doe", "12345abcde", "123 Main Street");

        });

    }



    @Test

    public void testAddressTooLongThrowsException() {

        String longAddress = "1234567890123456789012345678901"; // 31 chars

        assertThrows(IllegalArgumentException.class, () -> {

            new Contact("12345", "John", "Doe", "1234567890", longAddress);

        });

    }



    @Test

    public void testUpdateFields() {

        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");

        contact.setFirstName("Jane");

        contact.setLastName("Smith");

        contact.setPhone("0987654321");

        contact.setAddress("456 Elm Street");



        assertEquals("Jane", contact.getFirstName());

        assertEquals("Smith", contact.getLastName());

        assertEquals("0987654321", contact.getPhone());

        assertEquals("456 Elm Street", contact.getAddress());

    }

}

