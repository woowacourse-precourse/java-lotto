package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        isCorrectSize(numbers);
        isCorrectRange(numbers);
        isNoDuplicate(numbers);
    }

    private void isCorrectSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void isCorrectRange(List<Integer> numbers) throws IllegalArgumentException {
        if (!numbers.stream()
                .allMatch(number -> (number > 0 && number < 46))) {
            throw new IllegalArgumentException();
        }
    }

    private void isNoDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
