package seedu.address.model.util;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Instruction;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;
import seedu.address.model.task.UniqueTaskList.DuplicateTaskException;

public class SampleDataUtil {

    private static String[] sampleItems = new String[] {"apples", "bananas", "coconuts", "durians",
        "elderberries", "figs", "grapes", "honeydews", "imbes", "jackfruits", "kiwis", "lemons",
        "mangoes", "nectarines", "oranges", "pineapples", "quinces", "rambutans", "strawberries",
        "tangerines", "ugnis", "vanilla beans", "watermelons", "xango mangosteens", "yangmeis",
        "zuchinnis", "almonds", "bonbons", "cupcakes", "donuts", "eclairs", "froyos", "gingerbreads",
        "honeycombs", "ice cream sandwiches", "jellybeans", "kitkats", "lollipops", "marshmellows",
        "nougats", "orange tarts", "petit fours", "red velvet cakes", "swiss rolls", "tiramisus",
        "unsalted popcorns", "waffles", "xtremes", "yule logs", "zeppoles"};

    private static String[] sampleVerbs = new String[] {"Buy ", "Eat ", "Taste ", "Get "};

    private static String[] sampleDays = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday", "floating"};

    private static String[] samplePriorities = new String[] {"1", "2", "3", "4", "5", "-1"};

    public static Task[] getSampleTasks() {
        int numberOfTasks = 50;
        Task[] sampleTasks = new Task[numberOfTasks];
        for (int i = 0; i < numberOfTasks; i++) {
            try {
                int itemIndex = i % sampleItems.length;
                int verbIndex = i % sampleVerbs.length;
                int dayIndex = i % sampleDays.length;
                int priorityIndex = i % samplePriorities.length;

                sampleTasks[i] = new Task(new Title(sampleVerbs[verbIndex] + sampleItems[itemIndex]),
                        new Deadline(sampleDays[dayIndex]),
                        new Priority(samplePriorities[priorityIndex]),
                        new Instruction("Cheap offers"),
                        new UniqueTagList("groceries"));
            } catch (IllegalValueException e) {
                throw new AssertionError("sample data cannot be invalid", e);
            }
        }
        return sampleTasks;
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAB = new AddressBook();
            for (Task sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}
