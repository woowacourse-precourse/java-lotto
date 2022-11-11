package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import lotto.constant.ErrorMessage;
import lotto.userinterface.Output;

public class ExceptionHandler {
    public ExceptionHandler() {
    }

    public static void isListCorrectSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            Output.printMessage(ErrorMessage.NOT_CORRECT_SIZE_ERROR.getMessage(size));
            throw new IllegalArgumentException();
        }
    }

    public static void doesContainDuplicate(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicate = new HashSet<>(numbers);
        if (numbersWithoutDuplicate.size() < numbers.size()) {
            Output.printMessage(ErrorMessage.CONTAINS_DUPLICATE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isStringNumeric(String input) {
        String pattern = "^[0-9]*$";
        if (input == null) {
            Output.printMessage(ErrorMessage.NOT_NUMERIC_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches(pattern, input)) {
            Output.printMessage(ErrorMessage.NOT_NUMERIC_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isMultipleOf(long target, int multiple) {
        if (target % multiple != 0) {
            Output.printMessage(ErrorMessage.NOT_MULTIPLE_ERROR.getMessage(multiple));
            throw new IllegalArgumentException();
        }
    }

    public static void isWithinRange(int number, int start, int end) {
        if (number < start || number > end) {
            Output.printMessage(ErrorMessage.NOT_IN_RANGE_ERROR.getMessage(start, end));
            throw new IllegalArgumentException();
        }
    }

}
