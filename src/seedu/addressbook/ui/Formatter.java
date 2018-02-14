package seedu.addressbook.ui;

public class Formatter
{
    private static final String DIVIDER = "===================================================";
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /**
     * Pads line with decoration
     * @param line from a message
     * @return formatted line for display
     */
    public static String formatLine(String line)
    {
        return LINE_PREFIX + line.replace("\n", LS + LINE_PREFIX);
    }

    /**
     * gives the string representation of dividers
     * @param rows number of rows of divider
     * @return string that represents dividers
     */
    public static String getDivider(int rows) {
        String result = DIVIDER;
        while (rows > 1) {
            result += "\n" + DIVIDER;
            rows--;
        }
        return result;
    }
}
