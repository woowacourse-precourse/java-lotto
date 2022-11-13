package lotto.game.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 숫자가 6개가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long noDuplicateCount = numbers.stream()
                .distinct()
                .count();
        if (noDuplicateCount != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
