package contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            return false; // ID must be unique
        }
        contacts.put(id, contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        if (contactId == null) {
            return false;
        }
        return contacts.remove(contactId) != null;
    }

    public boolean updateFirstName(String contactId, String newFirstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setFirstName(newFirstName);
        return true;
    }

    public boolean updateLastName(String contactId, String newLastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setLastName(newLastName);
        return true;
    }

    public boolean updatePhone(String contactId, String newPhone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setPhone(newPhone);
        return true;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            return false;
        }
        contact.setAddress(newAddress);
        return true;
    }

    // Optional helper for tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
