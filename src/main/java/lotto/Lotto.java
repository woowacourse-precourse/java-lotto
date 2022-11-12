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
        // 범위 검사
        for (Integer num: numbers)
            if (num > 45 || num < 1)
                throw new IllegalArgumentException();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }


    // TODO: 추가 기능 구현
}
