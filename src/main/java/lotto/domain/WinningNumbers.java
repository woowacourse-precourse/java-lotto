package lotto.domain;

import java.util.List;

import lotto.utils.Validator;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers (List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.containDuplicate(numbers);
        Validator.listLengthCheck(numbers,6);
        for (int number : numbers) {
            Validator.isInRange(number);
        }
    }
}
