package lotto.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.Constant.*;
import static lotto.constants.Message.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    protected void validateLottoNumber(List<Integer> numbers) {
        if (hasInvalidLottoNumberLength(numbers)) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_LENGTH);
        }
        if (hasDuplicatedLottoNumber(numbers)) {
            throw new IllegalArgumentException(ERROR_HAS_DUPLICATED_LOTTO_NUMBER);
        }
        if (hasInvalidLottoNumberValue(numbers)) {
            throw new IllegalArgumentException(ERROR_HAS_INVALID_LOTTO_NUMBER_VALUE);
        }
    }

    private boolean hasInvalidLottoNumberValue(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isInvalidLottoNumberValue);
    }

    private boolean isInvalidLottoNumberValue(Integer number) {
        return LOTTO_START_NUMBER > number || LOTTO_END_NUMBER < number;
    }

    private boolean hasInvalidLottoNumberLength(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBER_LENGTH;
    }

    private boolean hasDuplicatedLottoNumber(List<Integer> numbers) {
        Set<Integer> eraseDuplicatedNumber = new HashSet<>(numbers);
        return eraseDuplicatedNumber.size() != LOTTO_NUMBER_LENGTH;
    }
}
