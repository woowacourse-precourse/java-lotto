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

    public boolean containNumber(int number) {
        if (this.numbers.contains(number)) {
            return true;
        }

        return false;
    }

    // TODO: 추가 기능 구현
}
