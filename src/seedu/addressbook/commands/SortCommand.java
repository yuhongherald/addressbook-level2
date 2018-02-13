package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;


/**
 * Shows all details of the person identified sorted by name.
 * Private contact details are shown.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list sorted by name.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> unsortedList = new ArrayList<>(addressBook.getAllPersons().immutableListView());
        List<ReadOnlyPerson> sortedList = new ArrayList<>();
        while (!unsortedList.isEmpty())
        {

        }
        return new CommandResult(getMessageForPersonListShownSummary(sortedList), sortedList);
    }
}
