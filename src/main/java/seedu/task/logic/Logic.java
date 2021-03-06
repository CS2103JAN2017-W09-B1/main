package seedu.task.logic;

import javafx.collections.ObservableList;
import seedu.task.logic.commands.CommandResult;
import seedu.task.logic.commands.exceptions.CommandException;
import seedu.task.model.task.ReadOnlyTask;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     */
    CommandResult execute(String commandText) throws CommandException;

  //@@author A0144813J
    /** Returns the filtered list of non-floating tasks */
    ObservableList<ReadOnlyTask> getFilteredNonFloatingTaskList();

    /** Returns the filtered list of floating tasks */
    ObservableList<ReadOnlyTask> getFilteredFloatingTaskList();

    /** Returns the filtered list of completed tasks */
    ObservableList<ReadOnlyTask> getFilteredCompletedTaskList();

}
