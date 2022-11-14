package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;

public class InputConverter {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private InputConverter() {
    }

    public static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_MESSAGE.toString());
        }
    }

    public static List<Integer> toIntegerList(String input) {
        try {
            return Stream.of(input.split(WINNING_NUMBERS_DELIMITER))
                    .map(InputConverter::toInteger)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_MESSAGE.toString());
        }
    }
}
