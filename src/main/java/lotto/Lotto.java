package lotto;

import java.util.List;

import static lotto.Application.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            printErrorAboutSize();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
