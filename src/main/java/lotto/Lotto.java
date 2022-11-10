package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLength(numbers);
        checkDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
    private void checkDuplicate(List<Integer> numbers) {
        for (int numberIndex = 0; numberIndex < numbers.size(); numberIndex++) {
            if (numbers.lastIndexOf(numbers.get(numberIndex)) != numberIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
