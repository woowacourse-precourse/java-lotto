package lotto.domain;

import java.util.List;
import lotto.utils.constants.ErrorMessage;
import lotto.utils.constants.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidNumberCount(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
        if (!isValidNumberRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
        if (!isValidNumberDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_DUPLICATION.getMessage());
        }
    }

    private boolean isValidNumberCount(List<Integer> numbers) {
        return numbers.size() == LottoConstant.LOTTO_SIZE.getNumber();
    }

    private boolean isValidNumberRange(List<Integer> numbers) {
        return numbers.stream().allMatch(
                (number) -> number >= LottoConstant.MIN_LOTTO.getNumber()
                        && number <= LottoConstant.MAX_LOTTO.getNumber());
    }

    private boolean isValidNumberDuplication(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() == LottoConstant.LOTTO_SIZE.getNumber();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
