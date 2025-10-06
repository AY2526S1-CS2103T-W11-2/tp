package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Remark;

/**
 * Parses input arguments and creates a new RemarkCommand object.
 */
public class RemarkCommandParser implements Parser<RemarkCommand> {

    @Override
    public RemarkCommand parse(String args) throws ParseException {
        requireNonNull(args);

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format("Invalid command format! Usage: %s", RemarkCommand.MESSAGE_USAGE));
        }

        String[] parts = trimmedArgs.split(" ", 2);
        if (parts.length < 2) {
            throw new ParseException(
                    String.format("Invalid command format! Usage: %s", RemarkCommand.MESSAGE_USAGE));
        }

        try {
            Index index = ParserUtil.parseIndex(parts[0]);
            Remark remark = new Remark(parts[1].trim());
            return new RemarkCommand(index, remark);
        } catch (Exception e) {
            throw new ParseException(
                    String.format("Invalid index! Usage: %s", RemarkCommand.MESSAGE_USAGE), e);
        }
    }
}
