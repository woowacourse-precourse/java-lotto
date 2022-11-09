package lotto.validator;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    public static void validate(List<Integer> numbers) {
        if (!isExactSize(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isOverlap(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isExactSize(List<Integer> numbers) {
        return numbers.size() == NUMBER_OF_LOTTO_NUMBERS;
    }

    private static boolean isOverlap(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != NUMBER_OF_LOTTO_NUMBERS;
    }
}
