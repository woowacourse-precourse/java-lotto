package lotto;

import java.util.LinkedList;
import java.util.List;

import static lotto.constants.ExceptionMessage.NO_LOTTO_NUMBERS;

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
    public List<Integer> getNumbers() {
        if(numbers == null) {
            throw new IllegalArgumentException(NO_LOTTO_NUMBERS);
        }
        return numbers;
    }
}
