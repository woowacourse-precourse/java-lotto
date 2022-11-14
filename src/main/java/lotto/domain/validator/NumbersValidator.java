package lotto.domain.validator;

import java.util.Collections;
import java.util.List;

public class NumbersValidator {
    private static int LOTTO_NUMBERS_SIZE = 6;
    private static int MIN_LOTTO_NUMBER = 1;
    private static int MAX_LOTTO_NUMBER = 45;
    private static String SIX_NUMBERS_ERROR_MESSAGE = "[ERROR] 6개로 구성돼야 합니다";
    private static String RANGE_ERROR_MESSAGE = String.format("[ERROR] %d ~ %d 사이의 숫자들로 구성돼야 합니다",
            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    private static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복없이 구성돼야 합니다";

    private static boolean isSixInputs(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBERS_SIZE;
    }

    private static boolean isInValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void validate(List<Integer> numbers) {
        if (!isSixInputs(numbers)) {
            throw new IllegalArgumentException(SIX_NUMBERS_ERROR_MESSAGE);
        }
        if (!isInValidRange(numbers)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
