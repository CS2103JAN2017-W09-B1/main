# Manual Testing Script
For : `[W09-B1][Burdens]`

---
## Sample data
To load the sample data into Burdens, key into the command box:

`cd path/to/folder/SampleData.xml`

example:

`cd ./SampleData.xml`

The command should load SampleData.xml into Burdens, showing 38 items in `Ongoing` section, 4 in `Floating` section and 8 in `Completed` section. The storage file path indicator directly above the command box should change to reflect the new storage file path in use.

## The commands

### Add command

Command:

`add Buy Apples`

Expected outcome: a task is added to and highlighted on `Floating` section of Burdens, titled `Buy Apples`, dated `floating`, priority level `decent`, noted `nothing yet` (the note is revealed by clicking onto the task).

Command:

`add Buy Watermelons for: Saturday 9am priority: 3 note: Fresh #fruits`

Expected outcome: a task is added to and highlighted on `Ongoing` section of Burdens, titled `Buy Watermelons`, dated `Sat, Apr 15 2017 09:00`, priority level `moderate`, tagged `fruits`, noted `Fresh` (the note is revealed by clicking onto the task).

### Calendar command

Command:

`cal Thursday 12pm`

Expected outcome: The `Result Display` box should display `The date is: Thu, Apr 13 2017 12:00`.

Command:

`cal Christmas 9am`

Expected outcome: The `Result Display` box should display `The date is: Mon, Dec 25 2017 09:00`.

### Complete command

Command:

`complete 1`

Expected outcome: The task titled `Buy quinces` indexed `1` on `Ongoing` section should be moved `Completed` section.

Command:

`complete floating 1`

Expected outcome: The task titled `Get nougats` indexed `1` on `Floating` section should be moved `Completed` section.

### Incomplete command

Command:

`incomplete 1`

Expected outcome: The task titled `Buy quinces` indexed `1` on `Completed` section should be moved to `Ongoing` section.

### Delete command

Command:

`delete 1`

Expected outcome: The task titled `Buy quinces` indexed `1` on `Ongoing` section should disappear.

Command:

`delete floating 1`

Expected outcome: The task titled `Get pineapples` indexed `1` on `Floating` section should disappear.

Command:

`delete completed 1`

Expected outcome: The task titled `Get nougats` indexed `1` on `Completed` section should disappear.

### Edit command

Command:

`edit 1 Buy Orange Tarts note: Very cheap offers for: Sunday 9am priority: 2 #home`

Expected outcome:  The task titled `Buy orange tarts`, priority level `urgent`, tagged `groceries`, noted `Cheap offers` indexed `1` on `Ongoing` section is changed to titled `Buy Orange Tarts`, priority level `decent`, tagged `home`, noted `Very cheap offers`, indexed `29` on `Ongoing` section.

### Exit command

Command:

`exit`

Expected outcome: The application exits.

### Export command

Commands:

`export ./test.ics`

Expected outcome: a file named `test.ics` appears in the same folder as the jar file of Burdens.

### Find command

Command:

`find Buy apples`

Expected outcome: the tasks displayed by Burdens change, `13` are displayed on `Ongoing` section, `1` on `Floating` and `2` on `Completed`.

Command:

`find #fruits`

Expected outcome: the displayed tasks change again, only `1` task displayed on `Ongoing` section titled `Buy Watermelons`.

### List command

Command:

`list`

Expected outcome: Burdens display all tasks, `38` on `Ongoing` section, `3` on `Floating` and `8` on `Completed` with tasks of priority level `urgent` put on lower indexes, followed by `forreal`, `moderate`, `decent`, and `lame`.

Command:

`list title`

Expected outcome: Burdens display all tasks by their titles' alphabetical order.

Command:

`list date`

Expected outcome: Burdens display all tasks by their titles' deadlines, with those with earlier deadlines followed by those with later deadlines.

### Help command

Command:

`help`

Expected outcome: a browser window appears showing Burdens' UserGuide.

### Import command

*The zip file contains a file named `teamCalendar.ics` which is needed to test the `Import` function. Please put `teamCalendar.ics` to the same folder as the jar file of Burdens.

Command:

`import teamCalendar.ics`

Expected outcome: the content of `teamCalendar.ics` is loaded and adds 2 tasks to Burdens at indexes 11 and 18. The former is titled `Team Project Presentation` and the latter `Team Project Final Evaluation`.

### Undo command

Command:

`delete 1`

`undo`

Expected outcome: the `delete` command deletes the task at index `1` of `Ongoing` section titled `Buy apples`. The `undo` command undoes the `delete` action and put `Buy apples` back to `Ongoing` section.

### Redo command

Command:

`redo`

Expected outcome: the `undo` command previously undid the change made by `delete` command and put `Buy apples` back to `Ongoing` section. The `redo` command reapplies the `delete` command, `Buy apples` disappears from `Ongoing`.

### Reset command

Command:

`reset`

Expected outcome: all tasks displayed by Burdens disappear.

*Please key in `undo` to undo the `reset` command before moving on.

### Select command

Command:

`select 1`

Expected outcome: The task titled `Buy imbes` indexed `1` on `Ongoing` section is highlighted.

Command:

`select floating 1`

Expected outcome: The task titled `Buy Apples` indexed `1` on `Floating` section is highlighted.

Command:

`select completed 1`

Expected outcome: The task titled `Get xango mangosteens` indexed `1` on `Completed` section is higlighed.

### Use command

Command:

`use create for add`

`create Test task`

Expected outcome: the `use` command maps keyword `create` as an alias for original command word `add`. Any subsequent commands starting with `create` is recognized as an `add` command; `create Test task` adds a task titled `Test task` to `Floating` section, indexed `4`.

Command:

`use make for create`

`make Another test task`

Expected outcome: the `use` command maps keyword `make` as an alias for alias `create` which in turn is an alias for original command word `add`. Any subsequent commands starting with `make` is recognized as an `add` command; `make Another test task` adds a task titled `Another test task` to `Floating` section, indexed `1`.

### Aliases command

Command:

`aliases`

Expected outcome: Burdens display all previously made aliases onto `Result Display`: `Listed all aliases: add: [create, make]`
