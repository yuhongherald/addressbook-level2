package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a contact detail in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String, String)}
 */
public abstract class Contact {

    public final String value;

    public Contact(String newValue, String regex, String constraints) throws IllegalValueException {
        value = newValue;
        String trimmedValue = newValue.trim();
        if (!isValidContact(trimmedValue, regex)) {
            throw new IllegalValueException(constraints);
        }
    }

    /**
     * Returns true if the contact is a valid contact.
     * @param test contact under test
     * @return if contact is valid
     */
    public static boolean isValidContact(String test, String regex) {
        return test.matches(regex);
    };

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
