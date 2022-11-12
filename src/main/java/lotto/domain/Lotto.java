package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.errorenum.Error;
import lotto.domain.lottoenum.LottoCondition;

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
        if (size != LottoCondition.LENGTH.getValue()) {
            throw new IllegalArgumentException(Error.NOT_6_LENGTH.getCode());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(this::checkIsInRange);
    }

    private void checkIsInRange(int number) {
        if (number >= LottoCondition.MIN.getValue() && number <= LottoCondition.MAX.getValue()) {
            return;
        }
        throw new IllegalArgumentException(Error.NOT_IN_RANGE.getCode());
    }

    private void validateNonDuplicate(List<Integer> numbers) {
        if (removeDuplicateNumbers(numbers) != LottoCondition.LENGTH.getValue()) {
            throw new IllegalArgumentException(Error.DUPLICATE_FOUND.getCode());
        }
    }

    private long removeDuplicateNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }
}
