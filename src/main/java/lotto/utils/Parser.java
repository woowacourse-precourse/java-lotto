package lotto.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static lotto.enumtype.LottoValidationMsg.NOT_FORMATTING_EXCEPTION;

public class Parser {

    public static List<Integer> getListOfIntegerSplitToString(String input, String delimiter) {
        List<String> splitInput = List.of(input.split(delimiter));
        return splitInput.stream()
                .map(Parser::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseInt(String input) {
        isParsable(input);
        return Integer.parseInt(input);
    }

    private static void isParsable(String input) {
        if (!validateFormatNumber(input)) {
            System.out.println(NOT_FORMATTING_EXCEPTION.getMessage());
            throw new NoSuchElementException(NOT_FORMATTING_EXCEPTION.getMessage());
        }
    }

    private static boolean validateFormatNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
