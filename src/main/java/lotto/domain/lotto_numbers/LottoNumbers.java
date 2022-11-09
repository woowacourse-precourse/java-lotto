package lotto.domain.lotto_numbers;

import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.INVALID_RANGE_OF_LOTTO_NUMBER;
import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.INVALID_SIZE_OF_LOTTO_NUMBERS;
import static lotto.domain.lotto_numbers.LottoNumbersErrorMessages.NOT_ALLOW_DUPLICATED_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface LottoNumbers {  // 검증 로직 중복을 제거하기 위함.

    default void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE_OF_LOTTO_NUMBERS);
        }
    }

    default void validateDuplication(List<Integer> numbers) {
        Set<Integer> setOfNumbers = new HashSet<>(numbers);
        if (setOfNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NOT_ALLOW_DUPLICATED_LOTTO_NUMBER);
        }
    }

    default void validateRangeOfNumbers(List<Integer> numbers) {
        boolean presentInvalidNumber = numbers.stream()
                .anyMatch(number -> number < 1 || 45 < number);

        if (presentInvalidNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_LOTTO_NUMBER);
        }
    }
}
