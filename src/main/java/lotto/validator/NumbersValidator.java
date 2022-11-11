package lotto.validator;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidator extends NumberValidator {
    private final static int INPUT_SIZE = 6;
    private final static String SIZE_ERROR_MESSAGE = "[ERROR] 당첨 로또는 6개입니다.";
    private final static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 포함되어 있습니다.";

    public static void validateNonNumericElements(List<String> input) {
        for (String element : input) {
            validateNonNumeric(element);
        }
    }

    public static void validateSize(List<String> input) {
        int inputSize = input.size();
        if (inputSize != INPUT_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateRangeNumbers(List<Integer> numbers) {
        for (int element : numbers) {
            validateRange(element);
        }
    }

    public static void validateAlreadyExist(Lotto numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}