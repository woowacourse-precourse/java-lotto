package lotto.domain;

import lotto.validator.InputValidator;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        super.getNumbers().forEach(InputValidator::validateNumberRange);
        InputValidator.validateNumberRange(bonusNumber);
    }
}
