package seedu.address.model.task;

import java.util.Objects;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.tag.UniqueTagList;

/**
 * @author ryuus
 * Represents a Task in the Instruction book.
 * Guarantees: details are present and not null, field values are validated.
 *
 */
public class Task implements ReadOnlyTask {

    private Title title;
    private Date date;
    private Priority priority;
    private Instruction instruction;

    private UniqueTagList tags;

    /**
     * Every field must be present and not null.
     */
    public Task(Title title, Date date, Priority priority, Instruction instruction, UniqueTagList tags) {
        assert !CollectionUtil.isAnyNull(title, date, priority, instruction, tags);
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.instruction = instruction;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
    }

    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this(source.getTitle(), source.getDate(), source.getPriority(), source.getInstruction(), source.getTags());
    }

    public void setTitle(Title title) {
        assert title != null;
        this.title = title;
    }

    @Override
    public Title getTitle() {
        return title;
    }

    public void setDate(Date date) {
        assert date != null;
        this.date = date;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void setPriority(Priority priority) {
        assert priority != null;
        this.priority = priority;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    public void setInstruction(Instruction instruction) {
        assert instruction != null;
        this.instruction = instruction;
    }

    @Override
    public Instruction getInstruction() {
        return instruction;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this Task's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    /**
     * Updates this Task with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyTask replacement) {
        assert replacement != null;

        this.setTitle(replacement.getTitle());
        this.setDate(replacement.getDate());
        this.setPriority(replacement.getPriority());
        this.setInstruction(replacement.getInstruction());
        this.setTags(replacement.getTags());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyTask // instanceof handles nulls
                && this.isSameStateAs((ReadOnlyTask) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, date, priority, instruction, tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }
}