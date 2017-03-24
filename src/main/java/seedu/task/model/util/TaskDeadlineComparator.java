package seedu.task.model.util;

import java.util.Comparator;
import java.util.Date;

import seedu.task.model.task.ReadOnlyTask;

public class TaskDeadlineComparator implements Comparator<ReadOnlyTask> {

    @Override
    public int compare(ReadOnlyTask firstTask, ReadOnlyTask secondTask) {
        Date firstDate = firstTask.getDeadline().toDeadline();
        Date secondDate = secondTask.getDeadline().toDeadline();
        return firstDate.compareTo(secondDate);
    }
}
