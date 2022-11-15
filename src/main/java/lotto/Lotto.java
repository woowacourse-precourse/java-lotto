package lotto;

import java.util.List;

import static lotto.collectionPrintout.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(exceptionHeader+wrongNumberSize);
        }
    }
    public void printNumbers() {
       System.out.print(this.numbers);
    }

    // TODO: 추가 기능 구현
}
