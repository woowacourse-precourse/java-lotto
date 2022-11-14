package lotto.exception;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constance.InputExceptionConstance.*;
import static lotto.constance.LottoConstance.END_RANDOM_NUMBER;
import static lotto.constance.LottoConstance.NUMBER_LENGTH;
import static lotto.util.Util.toList;
import static lotto.util.Util.toStringOfList;

public class InputException {
    private InputException() {
    }

    public static void validatesLottoAmount(String amount) {
        validateOnlyNumber(amount);
        validateDivisible(amount);
        validateMoreThan(amount);
    }

    public static List<Integer> validatesWinLottoNumber(String number) {
        validateNotSpace(number);
        validateNumberLength(number, NUMBER_LENGTH);
        validateOnlyNumber(number);
        validateSplitComma(number);
        validateNotDuplicate(number);
        validateBelow(number);
        return toList(number);
    }

    public static int validatesBonusNumber(String number) {
        validateOnlyNumber(number);
        validateNumberLength(number, BONUS_NUMBER_LENGTH);
        validateBelow(number);
        return Integer.parseInt(number);
    }

    private static void validateOnlyNumber(String number) {
        if (isWinLottoNumber(number)) {
            number = toStringOfList(toList(number));
        }
        if (!Pattern.matches(NUMBER_REGEX, number)) {
            exception(NOT_ONLY_NUMBER);
        }
    }

    private static boolean isWinLottoNumber(String number) {
        return number.contains(COMMA);
    }

    private static void validateDivisible(String number) {
        if (Integer.parseInt(number) % DIVIDING_NUMBER != 0) {
            exception(NOT_DIVISIBLE);
        }
    }

    private static void validateMoreThan(String number) {
        if (Integer.parseInt(number) < DIVIDING_NUMBER) {
            exception(MORE_THAN_NUMBER);
        }
    }

    private static void validateNumberLength(String number, int length) {
        List<Integer> numbers = toList(number);
        if (numbers.size() != length) {
            exception(NOT_SIX_LENGTH);
        }
    }

    public static void validateNotDuplicate(String number) {
        List<Integer> numbers = toList(number);
        if (numbers.stream().distinct().count() != NUMBER_LENGTH) {
            exception(NOT_DUPLICATE);
        }
    }

    private static void validateSplitComma(String number) {
        if (!number.contains(COMMA)) {
            exception(SPLIT_BY_COMMA);
        }
    }

    private static void validateBelow(String number) {
        List<Integer> numbers = toList(number);
        for (Integer num : numbers) {
            if (num > END_RANDOM_NUMBER) {
                exception(BELOW_BONUS_NUMBER);
            }
        }
    }

    private static void validateNotSpace(String number) {
        if(!Pattern.matches(SPACE_REGEX, number)) {
            exception(NOT_SPACE);
        }
    }

    private static void exception(String message) {
        throw new IllegalArgumentException(ERROR_FORM + message);
    }
}
