package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void duplicateValidate(List<Integer> numbers) {
        // 2-1. 로또 번호는 중복되지 않게 한다.
        if(new HashSet<>(numbers).size() != numbers.size()) throw new IllegalArgumentException();
    }
}
