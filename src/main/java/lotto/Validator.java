package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Validator {
    public static boolean isNotValidNumber(int n) {
        return n < 1 || n > 45;
    }

    public static boolean isDuplicatedNumber(List<Integer> numbers, int n) {
        return numbers.contains(n);
    }

    public static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList()).size() < numbers.size();
    }

    public static void checkConvertibleStringToNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.PARSING_NUMBER_ERROR.getMessage());
        }
    }
}
