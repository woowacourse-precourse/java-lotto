package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateInRangedNumbers(numbers);
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateInRangedNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복되지 않는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
