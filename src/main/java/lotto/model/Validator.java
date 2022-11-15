package lotto.model;

import static lotto.utils.ConstantUtil.ERROR;

public class Validator {
    private static final String BONUS_ERROR_MESSAGE = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
    }
}
