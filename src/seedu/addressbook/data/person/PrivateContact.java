package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class PrivateContact extends Contact {

    private boolean isPrivate;

    public PrivateContact(String newValue, String regex, String constraints, boolean isPrivate)
            throws IllegalValueException {
        super(newValue, regex, constraints);
        this.isPrivate = isPrivate;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
