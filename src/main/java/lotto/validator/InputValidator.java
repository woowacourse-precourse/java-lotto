package lotto.validator;

import lotto.domain.LottoCondition;
import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String INPUT_DELIMITER = ",";

    public static int changeInputToInt(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.getMessage());
        }

        return Integer.parseInt(input);
    }

    public static void validateNumberRange(int number) {
        if (number < LottoCondition.MIN_NUMBER.getNumber() || number > LottoCondition.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static List<Integer> changeInputToIntegerList(String input) {
        List<String> splitElements = Arrays.asList(input.split(INPUT_DELIMITER));
        List<Integer> numbers = splitElements.stream()
                .map(InputValidator::changeInputToInt)
                .collect(Collectors.toList());

        return numbers;
    }

    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
