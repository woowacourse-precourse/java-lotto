package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isCorrectSize(numbers);
        isDuplicated(numbers);
        this.numbers = numbers;
    }

    private void isCorrectSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 숫자를 입력해야 합니다.");
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        Set<Integer> duplicated = new HashSet<>(numbers);

        if (duplicated.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }
}
