package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.message.ErrorMessage.*;
import static lotto.instance.Setting.*;

public class Validation {

    public static void isNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

    public static void multipleBasicAmount(int input) throws IllegalArgumentException {
        if (input % BASIC_AMOUNT != 0) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_BASIC_AMOUNT);
        }
    }

    public static void canSplit(String[] split) throws IllegalArgumentException {
        if (split.length != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(CANNOT_SEPARATE);
        }
    }

    public static void inRange(int number) throws IllegalArgumentException {
        if ((number < START_RANGE) || (number > END_RANGE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    public static void inRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if ((number < START_RANGE) || (number > END_RANGE)) {
                throw new IllegalArgumentException(OUT_OF_RANGE);
            }
        }
    }

    public static void noDuplication(String[] split) throws IllegalArgumentException {
        HashSet<String> removeDuplication = new HashSet<>(List.of(split));
        if (removeDuplication.size() != split.length) {
            throw new IllegalArgumentException(REPETITION_NUMBERS);
        }
    }

    public static void noDuplication(int number, List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(REPETITION_NUMBER);
        }
    }

    public static void noDuplication(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> removeDuplication = new HashSet<>(numbers);
        if (removeDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException(REPETITION_NUMBERS);
        }
    }

    public static void validNumbersSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException(MORE_OR_LESS_NUMBERS);
        }
    }
}
