package lotto.model;

import static lotto.utils.ConstantUtil.ERROR;

import java.util.List;

public class Bonus {
    private static final String BONUS_ERROR_MESSAGE = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        validateBonusNumber(bonusNumber, winningLotto);
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
    }
}
