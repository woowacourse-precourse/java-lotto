package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또 번호가 필요합니다.");
        }

        Set<Integer> removedNumbers = new HashSet<>(numbers);
        if (removedNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재하면 안됩니다.");
        }
    }

    // TODO: 추가 기능 구현
}
