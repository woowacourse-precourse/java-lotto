package lotto;

import util.ExceptionMessage;
import util.LottoRule;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoRule.NUMBER_OF_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_SIZE);
        }
    }

}
