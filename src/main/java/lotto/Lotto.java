package lotto;

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
    public void print() {
        System.out.printf("[%d, %d, %d, %d, %d, %d]\n", numbers.get(0), numbers.get(1), numbers.get(2), numbers.get(5),
                numbers.get(4), numbers.get(5));
    }
}
