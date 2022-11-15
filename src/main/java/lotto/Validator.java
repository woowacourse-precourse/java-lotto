package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Validator {
    public static void checkNotValidNumber(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_RANGE_ERROR.getMessage());
        }
    }

    public static void checkDuplicatedNumber(List<Integer> numbers, int n) {
        if (numbers.contains(n)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkNumbersCount(int numbersCount) {
        if (numbersCount != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkIncludingDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() < numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkConvertibleStringToNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.PARSING_NUMBER_ERROR.getMessage());
        }
    }
}
