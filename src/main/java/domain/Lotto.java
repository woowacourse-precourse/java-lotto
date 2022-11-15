package domain;

import service.Rule;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumberInLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void checkSameNumberInLotto(List<Integer> numbers) {
        int uniqueNumberCount = (int) numbers.stream()
                .distinct()
                .count();

        if (uniqueNumberCount != Rule.PER_LOTTO.getCount()) {
            throw new IllegalArgumentException();
        }
    }
}
