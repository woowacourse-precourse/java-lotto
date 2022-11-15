package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    // TODO: 추가 기능 구현
}