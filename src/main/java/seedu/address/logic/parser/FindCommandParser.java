package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.KEYWORDS_ARGS_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;

import org.ocpsoft.prettytime.nlp.parse.DateGroup;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.IncorrectCommand;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;
import seedu.address.model.task.Deadline;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser {

    final ArgumentTokenizer argsTokenizer = new ArgumentTokenizer(PREFIX_DATE, PREFIX_TAG);

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns an FindCommand object for execution.
     */
    public Command parse(String args) {
        argsTokenizer.tokenize(args);
        Optional<UniqueTagList> tagList;
        Date date;
        try {
            tagList = parseTagsForFind(
                    ParserUtil.toSet(argsTokenizer.getAllValues(PREFIX_TAG))
                    );
             = parseDateForFind(argsTokenizer.getValue(PREFIX_DATE));
        } catch (IllegalValueException ive) {
            return new IncorrectCommand(ive.getMessage());
        }
        final Matcher matcher = KEYWORDS_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            return new IncorrectCommand(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        // keywords delimited by whitespace
        final String[] keywords = matcher.group("keywords").split("\\s+");
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        return new FindCommand(keywordSet);
    }

    /**
     * Parses {@code Collection<String> tags} into an {@code Optional<UniqueTagList>} if {@code tags} is non-empty.
     */
    private Optional<UniqueTagList> parseTagsForFind(Collection<String> tags) throws IllegalValueException {

        if (tags.isEmpty()) {
            return Optional.empty();
        }
        if (tags.size() == 1 && tags.contains("")) {
            throw new IllegalValueException(Tag.MESSAGE_TAG_CONSTRAINTS);
        }
        return Optional.of(ParserUtil.parseTags(tags));
    }

    /**
     * Parses {@code String date} into a {@code Date} if date is meaningful.
     */
    private Date parseDateForFind(Optional<String> date) throws IllegalValueException {
        if (!date.isPresent()) {
            return null;
        }
        List<DateGroup> dateGroup = Deadline.parseDeadline(date.get());
        if (!date.get().matches(Deadline.DATE_VALIDATION_REGEX) || dateGroup.size() == 0) {
            throw new IllegalValueException(Deadline.MESSAGE_DATE_CONSTRAINTS);
        }
        return dateGroup.get(0).getDates().get(0);
    }

}
