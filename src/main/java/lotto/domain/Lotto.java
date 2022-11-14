package lotto.domain;

import lotto.util.InputChecker;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        InputChecker.checkLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
