package lotto.domain.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        long correctNumberCount = numbers.stream()
                .distinct()
                .filter(num -> isInRange(num, 1, 45))
                .count();

        if (correctNumberCount != 6) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInRange(
            final int number,
            final int startInclusive,
            final int endInclusive
    ) {
        return (number >= startInclusive) && (number <= endInclusive);
    }

    // TODO: 추가 기능 구현

}
