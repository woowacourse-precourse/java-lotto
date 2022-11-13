package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkNumbersAreDifferent(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersAreDifferent(List<Integer> numbers) {
        int numbersCount = numbers.size();
        HashSet<Integer> tempNumbers = new HashSet<>(numbers);
        if (numbersCount != tempNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호로 중복된 숫자가 존재 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
