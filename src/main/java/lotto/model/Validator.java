package lotto.model;

import static lotto.utils.ConstantUtil.ERROR;
import static lotto.utils.ConstantUtil.MIN_LOTTO_PRICE;

public class Validator {
    private static final String MIN_MONEY_ERROR_MESSAGE = ERROR + "구입금액은 1000원 이상부터 가능합니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = ERROR + "구입금액은 1000원 단위만 가능합니다.";
    private static final String BONUS_ERROR_MESSAGE = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public void validateMinMoney(int money) {
        if (money < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
        }
    }

    public void validateMoneyUnit(int money) {
        if (isNotValidMoneyUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidMoneyUnit(int money) {
        return money % MIN_LOTTO_PRICE != 0;
    }
}
