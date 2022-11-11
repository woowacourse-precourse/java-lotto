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
    public List<Integer> setLotto() {
        return numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public void ascendingOrderSort() {
        Collections.sort(numbers);
    }
}
