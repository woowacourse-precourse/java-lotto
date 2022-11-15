package lotto.domain;

import lotto.utils.Constant;

import static lotto.domain.ResultMessage.calculateTotalWinningMoney;
import static lotto.utils.Constant.CURRENCY_UNIT;
import static lotto.utils.Constant.MINIMUM_AMOUNT;
import static lotto.utils.ExceptionMessage.INVALID_CURRENCY_UNIT;
import static lotto.utils.ExceptionMessage.LESS_THAN_MINIMUM_AMOUNT;
import static lotto.utils.Validation.validateNull;
import static lotto.utils.Validation.validateNumber;

public class PurchaseAmount {

    private final int amount;
    private final int lottoNum;

    public PurchaseAmount(String purchaseAmount) {
        this.amount = validate(purchaseAmount);
        this.lottoNum = getNumberOfLotto();
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    public int validate(String amountStr) {
        validateNull(amountStr);
        int amount = validateNumber(amountStr);
        validateRange(amount);

        return amount;
    }

    private void validateRange(int number) {
        if (number < MINIMUM_AMOUNT.getValue()) {
            throw new IllegalArgumentException(LESS_THAN_MINIMUM_AMOUNT.getMessage(MINIMUM_AMOUNT.getValue()));
        }

        if (number % CURRENCY_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(INVALID_CURRENCY_UNIT.getMessage(CURRENCY_UNIT.getValue()));
        }
    }

    private int getNumberOfLotto() {
        return amount / Constant.CURRENCY_UNIT.getValue();
    }

    public String calculateEarningsRate() {
        int earnings = calculateTotalWinningMoney();
        double earningsRate = Math.round(earnings * 1000 / amount) / 10.0;
        return earningsRate + "%";
    }
}

