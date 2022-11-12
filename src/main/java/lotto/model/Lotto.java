package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> lotto) {
        if (lotto.size() != lotto.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    // TODO: 추가 기능 구현
}
