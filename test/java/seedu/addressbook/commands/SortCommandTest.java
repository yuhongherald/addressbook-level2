package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.*;

public class SortCommandTest
{
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();

    @Test
    public void sortCommand_book_is_sorted_2_persons() {
        Person p = TestUtil.generateTestPerson();
        Person p2 = TestUtil.generateSmallerNameTestPerson();
        AddressBook book = new AddressBook();

        if (!p.isSmallerThanName(p2)) {
            Person tempPerson = p2;
            p2 = p;
            p = tempPerson;
        }
        try
        {
            book.addPerson(p);
            book.addPerson(p2);
        } catch (UniquePersonList.DuplicatePersonException e)
        {
            throw new RuntimeException("Persons should be different by Person definition");
        }
        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(book, EMPTY_PERSON_LIST);
        CommandResult result = sortCommand.execute();
        List<? extends ReadOnlyPerson> people;
        Optional<List<? extends ReadOnlyPerson>> relevantPersons = result.getRelevantPersons();
        if (relevantPersons.isPresent())
        {
            people = relevantPersons.get();
        } else {
            throw new RuntimeException("Relevant persons of sort command is invalid");
        }

        assertTrue(people.contains(p));
        assertTrue(people.contains(p2));
        assertEquals(2, people.size());
        assertEquals(people.get(0), p);
    }

    @Test
    public void sortCommand_book_is_not_sorted_2_persons() {
        Person p = TestUtil.generateTestPerson();
        Person p2 = TestUtil.generateSmallerNameTestPerson();
        AddressBook book = new AddressBook();

        if (p.isSmallerThanName(p2)) {
            Person tempPerson = p2;
            p2 = p;
            p = tempPerson;
        }
        try
        {
            book.addPerson(p);
            book.addPerson(p2);
        } catch (UniquePersonList.DuplicatePersonException e)
        {
            throw new RuntimeException("Persons should be different by Person definition");
        }
        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(book, EMPTY_PERSON_LIST);
        CommandResult result = sortCommand.execute();
        List<? extends ReadOnlyPerson> people;
        Optional<List<? extends ReadOnlyPerson>> relevantPersons = result.getRelevantPersons();
        if (relevantPersons.isPresent())
        {
            people = relevantPersons.get();
        } else {
            throw new RuntimeException("Relevant persons of sort command is invalid");
        }

        assertTrue(people.contains(p));
        assertTrue(people.contains(p2));
        assertEquals(2, people.size());
        assertEquals(people.get(0), p2);
    }

}