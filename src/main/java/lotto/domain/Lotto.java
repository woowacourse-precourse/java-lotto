package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 한 줄당 숫자가 6개가 아닙니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void checkLotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        boolean hasDuplicationNumber = numbers.stream()
                .distinct()
                .count() != numbers.size();
        if (hasDuplicationNumber) {
            throw new IllegalArgumentException("[ERROR] 로또의 한 줄 안에서 중복 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
