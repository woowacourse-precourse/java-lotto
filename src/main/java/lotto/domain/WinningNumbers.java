package lotto.domain;

import lotto.domain.validator.NumbersValidator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        NumbersValidator.validate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void registerBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
