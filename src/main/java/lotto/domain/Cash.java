package lotto.domain;

import static lotto.domain.LottoSetting.CASH_UNIT;
import static lotto.exception.CashExceptionMessage.CASH_NOT_MORE_THAN_EXCEPTION;
import static lotto.exception.CashExceptionMessage.WRONG_CASH_UNIT;

public class Cash {
    private int amount;

    public Cash(Integer amount) {
        this.amount = amount;
        validateMoreThanZero(this.amount);
        validateCashUnit(this.amount);
    }

    public void spend(int amount) {
        this.amount -= amount;
        validateMoreThanZero(this.amount);
    }

    public boolean afford(int amount) {
        return this.amount - amount >= 0;
    }

    private void validateMoreThanZero(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(CASH_NOT_MORE_THAN_EXCEPTION.getMessage());
        }
    }

    private void validateCashUnit(int amount) {
        if (amount % CASH_UNIT.getSetting() != 0) {
            throw new IllegalArgumentException(WRONG_CASH_UNIT.getMessage());
        }
    }
}
