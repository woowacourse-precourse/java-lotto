package lotto.model;

import lotto.model.enums.ErrorMessage;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public boolean isIncludeBonus(int luckyBonus) {
        return numbers.contains(luckyBonus);
    }

    public int hasSameElement(Lotto drawNumber) {
        List<Integer> sameNumber = numbers.stream()
                .filter(numbers -> drawNumber.numbers.stream().anyMatch(Predicate.isEqual(numbers)))
                .collect(Collectors.toList());
        return sameNumber.size();
    }
}
