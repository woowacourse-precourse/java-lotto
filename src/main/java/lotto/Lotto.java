package lotto;

import java.util.List;

import static lotto.constant.MessageConstant.*;

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
    public void printResult() {
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 6, FIRST.getMessage(), numbers.get(5)));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 5, SECOND.getMessage(), numbers.get(4)));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 5, THIRD.getMessage(), numbers.get(3)));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 4, FOURTH.getMessage(), numbers.get(2)));
        System.out.println(String.format(COUNT_MESSAGE.getMessage(), 3, FIFTH.getMessage(), numbers.get(1)));
    }
}
