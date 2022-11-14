package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRangeOfNumbers(numbers);
        checkDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkRangeOfNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkDuplicatedNumber(List<Integer> numbers) {
        for (int i = 0; i < 5; i++) {
            int currentNumber = numbers.get(i);
            int nextNumber = numbers.get(i+1);
            if (currentNumber == nextNumber) {
                throw new IllegalArgumentException();
            }

        }
    }


}
