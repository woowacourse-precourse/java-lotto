package lotto.utils;

import java.util.List;

public class Validation {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumber(numbers);
    }

    private static void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_FIRST_NUMBER || number > LOTTO_LAST_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
    }
}
