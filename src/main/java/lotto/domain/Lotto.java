package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.errorenum.Error;
import lotto.domain.lottoenum.LottoCondition;
import lotto.util.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers.size());
        validateInRange(numbers);
        validateNonDuplicate(numbers);
    }

    private void validateLength(int size) {
        if (!LottoNumberValidator.isCorrectLength(size)) {
            throw new IllegalArgumentException(Error.NOT_6_LENGTH.getCode());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validateInRange);
    }

    private void validateNonDuplicate(List<Integer> numbers) {
        if (!LottoNumberValidator.isCorrectLength(getDuplicateRemovedCount(numbers))) {
            throw new IllegalArgumentException(Error.DUPLICATE_FOUND.getCode());
        }
    }

    private int getDuplicateRemovedCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .distinct()
                .count();
    }
}
