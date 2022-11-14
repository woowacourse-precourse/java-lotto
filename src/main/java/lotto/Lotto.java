package lotto;

import static lotto.constant.Rules.NUMBER_LENGTH;

import java.util.List;
import lotto.exception.NotDistinctException;
import lotto.exception.WrongLengthException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new WrongLengthException();
        }
        if (!verifyDistinct(numbers)) {
            throw new NotDistinctException();
        }
    }

    private boolean verifyDistinct(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }
}
