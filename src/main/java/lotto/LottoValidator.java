package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final String INVALID_LOTTO_COUNT = "[ERROR] 로또 번호는 6개 이어야 합니다.";
    private static final String DUPLICATED_LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    private static final int LOTTO_NUMBER_COUNT = 6;

    public static void isValidNumbers(List<Integer> numbers) {
        isValidCount(numbers);
        isDuplicated(numbers);
    }

    private static void isValidCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT);
        }
    }

    private static void isDuplicated(List<Integer> numbers) {
        Set<Integer> duplicated = new HashSet<>(numbers);

        if (duplicated.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }
}
