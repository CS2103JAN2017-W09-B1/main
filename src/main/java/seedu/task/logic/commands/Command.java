package seedu.task.logic.commands;

import java.util.List;

import seedu.task.commons.core.Messages;
import seedu.task.commons.core.UnmodifiableObservableList;
import seedu.task.logic.commands.exceptions.CommandException;
import seedu.task.model.Model;
import seedu.task.model.task.ReadOnlyTask;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {
    protected Model model;

    /**
     * Constructs a feedback message to summarise an operation that displayed a listing of persons.
     *
     * @param displaySize used to generate summary
     * @return summary message for persons displayed
     */
    public static String getMessageForTaskListShownSummary(int displaySize) {
        return String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, displaySize);
    }

    /**
     * Returns the list of tasks corresponds to the given string.
     *
     * @param targetList
     * @return the intended list of tasks
     */
    protected UnmodifiableObservableList<ReadOnlyTask> getTargetTaskList(String targetList) {
        UnmodifiableObservableList<ReadOnlyTask> lastShownList;
        switch (targetList) {
        case ReadOnlyTask.TASK_NAME_FLOATING:
            lastShownList = model.getFloatingTaskList();
            break;
        case ReadOnlyTask.TASK_NAME_COMPLETED:
            lastShownList = model.getCompletedTaskList();
            break;
        default:
            lastShownList = model.getNonFloatingTaskList();
            break;
        }
        return lastShownList;
    }

    /**
     * Throws an exception if the given index number is invalid for the given task list
     *
     * @param targetIndex
     * @param taskList
     * @throws CommandException
     */
    protected void validateTargetIndex(int targetIndex, List<ReadOnlyTask> taskList) throws CommandException {
        if (targetIndex >= taskList.size() || taskList.isEmpty()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }
    }

    /**
     * Executes the command and returns the result message.
     *
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute() throws CommandException;

    /**
     * Provides any needed dependencies to the command.
     * Commands making use of any of these should override this method to gain
     * access to the dependencies.
     */
    public void setData(Model model) {
        this.model = model;
    }

}
