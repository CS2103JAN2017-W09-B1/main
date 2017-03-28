package guitests;

import org.junit.Test;

import seedu.task.logic.commands.UndoCommand;
import seedu.task.testutil.TestTask;

public class UndoCommandTest extends TaskManagerGuiTest {

    @Test
    public void undo_emptySession_failure() {
        commandBox.runCommand("undo");
        assertResultMessage(UndoCommand.MESSAGE_NO_BACKWARDS_COMMAND);
    }

    @Test
    public void undo_noPreviousCommand_failure() {
        //End of state stack
        commandBox.runCommand("delete 1");
        commandBox.runCommand("undo");
        commandBox.runCommand("undo");
        assertResultMessage(UndoCommand.MESSAGE_NO_BACKWARDS_COMMAND);

        commandBox.runCommand("delete 1");
        commandBox.runCommand("undo");
        commandBox.runCommand("undo");
        assertResultMessage(UndoCommand.MESSAGE_NO_BACKWARDS_COMMAND);
        commandBox.runCommand("undo");
        assertResultMessage(UndoCommand.MESSAGE_NO_BACKWARDS_COMMAND);
    }

    @Test
    public void undo_addThenUndo_success() throws Exception {
        TestTask taskToAdd = td.hoon;
        commandBox.runCommand(taskToAdd.getAddCommand());

        assertUndoSuccess();
    }

    @Test
    public void undo_clearThenUndo_success() throws Exception {
        commandBox.runCommand("clear");

        assertUndoSuccess();
    }

    @Test
    public void undo_deleteThenUndo_success() throws Exception {
        commandBox.runCommand("delete 1");

        assertUndoSuccess();
    }

    @Test
    public void undo_editThenUndo_success() throws Exception {
        String detailsToEdit = "Bobby d/91234567 p/1 i/Block 123, Bobby Street 3 t/husband";
        int taskListIndex = 1;

        commandBox.runCommand("edit " + taskListIndex + " " + detailsToEdit);

        assertUndoSuccess();
    }

    @Test
    public void undo_markCompleteThenUndo_success() throws Exception {
        commandBox.runCommand("complete 1");

        assertUndoSuccess();

        commandBox.runCommand("edit 1 d/floating");
        commandBox.runCommand("complete floating 1");

        assertUndoSuccess();
    }

    @Test
    public void undo_markIncompleteThenUndo_success() throws Exception {
        commandBox.runCommand("complete 1");
        commandBox.runCommand("incomplete 1");

        assertUndoSuccess();
    }

    /**
     * Runs the undo command to undo the previously executed command and confirms the result is correct.
     * @param targetIndexOneIndexed e.g. index 1 to delete the first person in the list,
     * @param currentList A copy of the current list of persons (before deletion).
     */
    private void assertUndoSuccess() {
        commandBox.runCommand("undo");

        assertResultMessage(UndoCommand.MESSAGE_SUCCESS);

    }

}

