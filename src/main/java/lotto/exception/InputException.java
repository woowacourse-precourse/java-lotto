package lotto.exception;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constance.InputExceptionConstance.*;
import static lotto.constance.LottoConstance.END_RANDOM_NUMBER;
import static lotto.constance.LottoConstance.NUMBER_LENGTH;

public class InputException {
    private InputException() {}

    public static void validatesLottoAmount(String amount) {
        validateNumberByValue(amount, LOTTO_AMOUNT);
        validateSplit(amount);
        validateUnder(amount);
    }

    public static List<Integer> validatesWinLottoNumber(String number) {
        validateLength(number, NUMBER_LENGTH);
        validateNumberByValue(number, WIN_LOTTO_NUMBER);
        validateSplitComma(number);
        validateDuplicate(number);
        validateNotExceed(number);
        return toList(number);
    }

    public static int validatesBonusNumber(String number) {
        validateNumberByValue(number, BONUS_NUMBER);
        validateLength(number, BONUS_NUMBER_LENGTH);
        validateNotExceed(number);
        return Integer.parseInt(number);
    }

    private static void validateNumberByValue(String number, String value) {
        if(value.equals(WIN_LOTTO_NUMBER)) {
            number = toString(toList(number));
        }
        validateNumber(number);
    }

    private static void validateNumber(String number) {
        if(!Pattern.matches(NUMBER_REGEX, number)) {
            exception(NOT_NUMBER);
        }
    }

    private static void validateSplit(String number) {
        if(Integer.parseInt(number) % SPLIT_NUMBER != 0) {
            exception(NOT_SPLIT_1000);
        }
    }

    private static void validateUnder(String number) {
        if(Integer.parseInt(number) < SPLIT_NUMBER) {
            exception(UNDER_1000);
        }
    }

    private static void validateLength(String number, int length) {
        List<Integer> numbers = toList(number);
        if(numbers.size() != length) {
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
        List<Integer> numbers = toList(number);
        for(Integer num : numbers) {
            if(num > END_RANDOM_NUMBER) {
                exception(NOT_EXCEEDING_45);
            }
        }
    }

    private static void exception(String message) {
        throw new IllegalArgumentException(ERROR_FORM + message);
    }

    private static int[] toIntArray(String inputNumbers) {
        return Stream.of(inputNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private static List<Integer> toList(String inputNumbers) {
        int[] numbers = toIntArray(inputNumbers);
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }

    private static String toString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(sb::append);
        return sb.toString();
    }
}
