package lotto.exception;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constance.BasicConstance.NUMBER_LENGTH;
import static lotto.constance.InputExceptionConstance.*;

public class InputException {
    private InputException() {}

    public static void validatesLottoAmount(String amount) {
        validateNumber(amount);
        validateSplit(amount);
        validateUnder(amount);
    }

    public static List<Integer> validatesWinLottoNumber(String number) {
        validateLength(number);
        validateNumber(number);
        validateSplitComma(number);
        validateDuplicate(number);
        validateNotExceed(number);
        return toList(number);
    }

    private static void validateNumber(String number) {
        if(!Pattern.matches(NUMBER_REGEX, number)) {
            exception(NOT_NUMBER);
        }
    }

    private static void validateSplit(String number) {
        if(Integer.parseInt(number) % 1000 != 0) {
            exception(NOT_SPLIT_1000);
        }
    }

    private static void validateUnder(String number) {
        if(Integer.parseInt(number) < 1000) {
            exception(UNDER_1000);
        }
    }

    private static void validateLength(String number) {
        if(number.length() != NUMBER_LENGTH) {
            exception(NOT_LENGTH);
        }
    }

    private static void validateDuplicate(String number) {
        List<Integer> numbers = toList(number);
        if(numbers.stream().distinct().count() != NUMBER_LENGTH) {
            exception(NOT_DUPLICATE);
        }
    }

    private static void validateSplitComma(String number) {
        if(!number.contains(COMMA)) {
            exception(NOT_SPLIT_COMMA);
        }
    }

    private static void validateNotExceed(String number) {
        if(Integer.parseInt(number) > 45) {
            exception(NOT_EXCEEDING_45);
        }
    }

    private static void exception(String message) {
        throw new IllegalArgumentException(ERROR_FORM + message);
    }

    public static int[] toIntArray(String inputNumbers) {
        return Stream.of(inputNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> toList(String inputNumbers) {
        int[] numbers = toIntArray(inputNumbers);
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
