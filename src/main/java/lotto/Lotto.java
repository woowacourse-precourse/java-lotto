package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Constants.*;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        validateRange(numbers);
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + NOT_SIX_NUMBERS);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        List<Integer> numbersToBeValidated = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbersToBeValidated.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < START_NUMBER_INCLUSIVE || number > END_NUMBER_INCLUSIVE );
        if (isOutOfRange) {
            throw new IllegalArgumentException(ERROR_TITLE + OUT_OF_RANGE);
        }
    }
}
