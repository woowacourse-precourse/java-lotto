package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    private void validateDuplicate(List<Number> numbers) {
        if (deduplicateNumbers(numbers) != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private long deduplicateNumbers(List<Number> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 개수는 총 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
