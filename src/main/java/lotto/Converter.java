package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    public static Integer StringToInteger(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException error) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_RANGE_ERROR);
            throw new IllegalArgumentException(message);
        }
    }

    public static List<Integer> StringToListInteger(String target, String parser) {
        try {
            return Stream.of(target.split(parser))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException error) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_PARSER_ERROR);
            throw new IllegalArgumentException(message);
        }
    }
}
