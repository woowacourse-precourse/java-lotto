package lotto.domain;

import java.util.List;

import lotto.utils.Validator;

public class WinningNumbers {
    private List<Integer> numbers;

    public WinningNumbers (List<Integer> numbers) {
        Validator.validateWinningNumber(numbers);
        this.numbers = numbers;
    }
}
