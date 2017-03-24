package seedu.task.commons.events.model;

import seedu.task.commons.core.UnmodifiableObservableList;
import seedu.task.commons.events.BaseEvent;
import seedu.task.model.ReadOnlyTaskManager;
import seedu.task.model.task.ReadOnlyTask;

/** Indicates the AddressBook in the model has changed*/
public class TaskManagerChangedEvent extends BaseEvent {

    public final ReadOnlyTaskManager data;
    public UnmodifiableObservableList<ReadOnlyTask> nonFloatingTasks;
    public UnmodifiableObservableList<ReadOnlyTask> floatingTasks;
    public UnmodifiableObservableList<ReadOnlyTask> completedTasks;

    //UNDO OR REDO HERE
    public TaskManagerChangedEvent(ReadOnlyTaskManager data) {
        this.data = data;
    }

    public void setNonFloatingTasks(UnmodifiableObservableList<ReadOnlyTask> nonFloatingTasks) {
        this.nonFloatingTasks = nonFloatingTasks;
    }

    public void setFloatingTasks(UnmodifiableObservableList<ReadOnlyTask> floatingTasks) {
        this.floatingTasks = floatingTasks;
    }

    public void setCompletedTasks(UnmodifiableObservableList<ReadOnlyTask> completedTasks) {
        this.completedTasks = completedTasks;
    }

    @Override
    public String toString() {
        return "number of tasks " + data.getTaskList().size() + ", number of tags " + data.getTagList().size();
    }
}
