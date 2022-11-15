package lotto.domain.validator;

import java.util.Collections;
import java.util.List;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.LottoConstants.MAX_LOTTO_NUMBER;

public class NumbersValidator {
    private static String SIX_NUMBERS_ERROR_MESSAGE = "[ERROR] 6개로 구성돼야 합니다";
    private static String RANGE_ERROR_MESSAGE = String.format("[ERROR] %d ~ %d 사이의 숫자들로 구성돼야 합니다",
            MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue());
    private static String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복없이 구성돼야 합니다";

    private static boolean isSixInputs(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE.getValue();
    }

    private static boolean isInValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < number) {
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
