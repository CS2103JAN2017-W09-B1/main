package seedu.address.model.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * @author ryuus
 *
 */
public class InstructionTest {

    @Test
    public void isValidInstruction() {
        // invalid instructions
        assertFalse(Instruction.isValidInstruction("")); // empty string
        assertFalse(Instruction.isValidInstruction(" ")); // spaces only

        // valid instructions
        assertTrue(Instruction.isValidInstruction("Cook the egg then put it back into the shell"));
        assertTrue(Instruction.isValidInstruction("-")); // one character
        assertTrue(Instruction.isValidInstruction("Leng Inc; 1234 Market St; "
             + "San Francisco CA 2349879; USA")); // long address
    }

    @Test
    public void equalsTest() {
        try {
            Instruction firstInstruction = new Instruction("Cook the egg then put it back into the shell");
            Instruction secondInstruction = new Instruction("No do not put it back into the shell");
            assertFalse(firstInstruction.equals(secondInstruction));
        } catch (IllegalValueException e) {
        }
    }
}
