package lotto.model;

import java.util.List;

public class Bonus {

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        Validator validator = new Validator();
        validator.validateNumberRange(bonusNumber);
        validator.validateBonusNumber(bonusNumber, winningLotto);
    }
}
