package lotto.model;

import lotto.utils.ErrorStatus;
import lotto.utils.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validation.validateOthers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorStatus.NUMBERS_SIZE.printError());
        }
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}
