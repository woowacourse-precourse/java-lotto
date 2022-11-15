package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoSetting.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoSetting.LOTTO_MIN_NUMBER;
import static lotto.exception.LottoExceptionMessage.LOTTO_DUPLICATED_NUMBER;
import static lotto.exception.LottoExceptionMessage.LOTTO_WRONG_NUMBER_SIZE;
import static lotto.exception.LottoWinNumberExceptionMessage.LOTTO_NUMBER_OVER_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_WRONG_NUMBER_SIZE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean validateWinNumberResult = numbers.stream()
                .anyMatch(number ->
                        LOTTO_MIN_NUMBER.getSetting() > number || number > LOTTO_MAX_NUMBER.getSetting());
        if (validateWinNumberResult) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        Collections.sort(numbers);
        return new ArrayList<>(numbers);
    }
}
