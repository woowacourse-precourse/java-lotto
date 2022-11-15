package lotto.domain;

import lotto.validation.InputValidation;
import lotto.view.InputView;

import static lotto.constant.LottoConstant.PRICE;

public class Amount {

    private int amount;

    public Amount(String amount) {
        InputValidation.isNumber(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int calculateBallCount() {
        InputValidation.isValidUnit(amount);
        return amount / PRICE.getValue();
    }

    public int getAmount() {
        return amount;
    }
}
