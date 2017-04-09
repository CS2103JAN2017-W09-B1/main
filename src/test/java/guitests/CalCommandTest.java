//@@author A0142644J
package guitests;

import static seedu.task.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import org.junit.Test;

import seedu.task.logic.commands.CalCommand;

public class CalCommandTest extends TaskManagerGuiTest {

    @Test
    public void cal() {

        //valid command
        commandBox.runCommand("cal 7 April 2017 12pm");
        assertResultMessage(String.format(CalCommand.MESSAGE_SUCCESS, "Fri, Apr 7 2017 12:00"));

        //invalid command
        commandBox.runCommand("cal nothing");
        assertResultMessage(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalCommand.MESSAGE_USAGE));

    }

}
