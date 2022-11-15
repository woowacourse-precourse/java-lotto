package lotto.domain;

import lotto.domain.validator.BonusNumberValidator;
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
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        BonusNumberValidator.validate(this, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
