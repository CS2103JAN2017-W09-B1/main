package seedu.address.model.task;

import seedu.address.model.tag.UniqueTagList;

/**
 * @author ryuus
 *
 */
public interface ReadOnlyTask {

    Title getTitle();
    Date getDate();
    Priority getPriority();
    Instruction getInstruction();

    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyTask other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getTitle().equals(this.getTitle()) // state checks here onwards
                && other.getDate().equals(this.getDate())
                && other.getPriority().equals(this.getPriority())
                && other.getInstruction().equals(this.getInstruction()));
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Date: ")
                .append(getDate())
                .append(" Priority: ")
                .append(getPriority())
                .append(" Instruction: ")
                .append(getInstruction())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}
