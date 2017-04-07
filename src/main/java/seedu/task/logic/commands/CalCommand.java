//@@author A0142644J
package seedu.task.logic.commands;

import static seedu.task.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.logic.commands.exceptions.CommandException;
import seedu.task.model.task.Deadline;

/**
 * Allows user to key in days in natural language
 * and returns a date in EEE, MMM d yyyy HH:mm format
 */

public class CalCommand extends Command {

    public static final String COMMAND_WORD = "cal";

    public static final String MESSAGE_SUCCESS = "The date is: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Returns a date in EEE, MMM d yyyy HH:mm format. "
            + "Parameters: DAY\n"
            + "DAY must contain some date.\n"
            + "Example: " + COMMAND_WORD + " Sunday";

    private final String date;

    public CalCommand(String day) {
        this.date = day;
    }

    @Override
    public CommandResult execute() throws CommandException {
        Deadline day = null;
        try {
            day = new Deadline(date);
        } catch (IllegalValueException e) {
            throw new CommandException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, day.value));
    }
}
