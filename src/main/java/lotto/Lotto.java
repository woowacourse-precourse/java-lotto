package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
        repeated(numbers);
    }
    // 6자리 아닌 값 확인
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    // 중복된 숫자 확인
    private void repeated(List<Integer> numbers) {
        HashSet<Integer> check_repeat = new HashSet<>(numbers);
        if (numbers.size() != check_repeat.size()) {
            throw new IllegalArgumentException();
        }
    }
}
