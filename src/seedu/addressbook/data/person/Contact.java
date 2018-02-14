package seedu.addressbook.data.person;

public abstract class Contact {
    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String CONTACT_VALIDATION_REGEX = ".*"; // anything is valid
    public final String value = null;

    public static boolean isValid(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
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
