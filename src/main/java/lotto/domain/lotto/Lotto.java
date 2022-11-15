package lotto.domain.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        long correctNumberCount = numbers.stream()
                .distinct()
                .filter(num -> isInRange(num, 1, 45))
                .count();

        if (correctNumberCount != 6) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isInRange(
            final int number,
            final int startInclusive,
            final int endInclusive
    ) {
        return (number >= startInclusive) && (number <= endInclusive);
    }

    public int countMatchNumbers(Lotto target) {
        return (int) target.numbers
                .stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean contains(final int number) {
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        numbers.forEach(i -> sb.append(", ").append(i));  // [, 1, 2, 3

        sb.append("]");
        return sb.toString().replaceFirst(", ", "");
    }
}
