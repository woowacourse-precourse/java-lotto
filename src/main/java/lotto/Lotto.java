package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // 서로 다른 숫자로 구성되었는지 검증하는 기능
    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        if (numbers.size() != lotto.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자로 구성되어 있지 않습니다.");
        }
    }
}
