package lotto.valid;

import lotto.domain.LottoMachine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum LottoValidator {
    INSTANCE;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.";
    private static final String LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    public static void validate(List<Integer> numbers) {
        checkRange(numbers);
        checkSize(numbers);
        checkDuplicate(numbers);
    }

    private static void checkRange(List<Integer> numbers) {
        boolean incorrectNumberExists = numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);

        if (incorrectNumberExists) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
