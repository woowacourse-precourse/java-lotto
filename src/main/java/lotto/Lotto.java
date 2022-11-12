package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean containsNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        System.out.println(numbers);
    }
}
