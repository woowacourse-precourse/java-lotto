package lotto;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final int LOTTO_NUMBER_SIZE = 6;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(GameMessage.LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(GameMessage.RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(GameMessage.DUPLICATE_ERROR_MESSAGE.getMessage());
        }
    }

    public boolean isIncludeBonus(int luckyBonus) {
        return numbers.contains(luckyBonus);
    }

    public int hasSameElement(List<Integer> drawNumber) {
        List<Integer> sameNumber = numbers.stream()
                .filter(numbers -> drawNumber.stream().anyMatch(Predicate.isEqual(numbers)))
                .collect(Collectors.toList());
        return sameNumber.size();
    }
}
