package lotto.domain;

import lotto.constants.ErrorMessages;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonus(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(List<Integer> numbers, int bonusNumber) {
        if (checkBonusDuplicate(numbers, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_DUPLICATE);
        }
    }

    private boolean checkBonusDuplicate(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean containsBonus(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
