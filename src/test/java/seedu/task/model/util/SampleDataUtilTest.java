package seedu.task.model.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.task.model.ReadOnlyTaskManager;
import seedu.task.model.task.Task;
import seedu.task.model.util.SampleDataUtil;

public class SampleDataUtilTest {

    @Test
    public void getSampleTasksTest() {
        Task[] sampleTasks = SampleDataUtil.getSampleTasks();
        assertNotNull(sampleTasks);
        assertTrue(sampleTasks.length == 6);
    }

    @Test
    public void getSampleAddressBookTest() {
        ReadOnlyTaskManager sampleAB = SampleDataUtil.getSampleTaskManager();
        assertNotNull(sampleAB);
        assertTrue(sampleAB.getTaskList().size() == 6);
    }

}
