package lotto.model;

import java.util.List;
import lotto.util.constants.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateRange(numbers);
        validateUniqueNumber(numbers);
    }

    private void validateSize(int numberSize) {
        if (!isSameSizeAsLotto(numberSize)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_IS_NOT_SAME_LOTTO_SIZE);
        }
    }

    private boolean isSameSizeAsLotto(int numberSize) {
        return numberSize == LottoConstants.LOTTO_TICKET_SIZE;
    }

    private void validateRange(List<Integer> numbers) {
        if (!isSameRangeAsLottoNumber(numbers)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_IS_NOT_SAME_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isSameRangeAsLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(num -> num >= LottoConstants.LOTTO_NUMBER_MIN && num <= LottoConstants.LOTTO_NUMBER_MAX);
    }

    private void validateUniqueNumber(List<Integer> numbers) {
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_IS_NOT_UNIQUE_LOTTO_NUMBER);
        }
    }

    private boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != LottoConstants.LOTTO_TICKET_SIZE;
    }
}
