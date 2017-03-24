package seedu.task.logic.commands;

import java.util.List;
//import java.util.Optional;

import seedu.task.logic.commands.exceptions.CommandException;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.task.Task;
import seedu.task.model.task.UniqueTaskList;


/**
 * Edits the details of an existing task in the instruction book.
 */
public class IncompleteCommand extends Command {

    public static final String COMMAND_WORD = "incomplete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the task as incomplete "
            + "by the index number used in the last task listing. "
            + "Completed priority level will be changed to previous priority level "
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_MARK_INCOMPLETE_SUCCESS = "Incompleted Task: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the instruction book.";

    private final int filteredTaskListIndex;

    /**
     * @param filteredTaskListIndex the index of the task in the filtered task list to edit
     * @param editTaskDescriptor details to edit the task with
     */
    public IncompleteCommand(int filteredTaskListIndex) {
        assert filteredTaskListIndex > 0;

        // converts filteredTaskListIndex from one-based to zero-based.
        this.filteredTaskListIndex = filteredTaskListIndex - 1;
    }

    @Override
    public CommandResult execute() throws CommandException {
        List<ReadOnlyTask> lastShownList = getTargetTaskList(Task.TASK_NAME_COMPLETED);

        validateTargetIndex(filteredTaskListIndex, lastShownList);

        ReadOnlyTask taskToEdit = lastShownList.get(filteredTaskListIndex);
        Task editedTask = new Task(taskToEdit);
        editedTask.setAsIncompleted();
        try {
            model.updateTask(Task.TASK_NAME_COMPLETED, filteredTaskListIndex, editedTask);
        } catch (UniqueTaskList.DuplicateTaskException dpe) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }
        return new CommandResult(String.format(MESSAGE_MARK_INCOMPLETE_SUCCESS, editedTask));
    }
}
