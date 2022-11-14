package lotto.domain;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;
import lotto.validation.IntegerValidation;

public class Money {

    private final int money;

    public Money(String money) {
        numericFormat(money);
        divideByInteger(money);
        this.money = Integer.parseInt(money);
    }

    public int moneyDivideBy(int divisor) {
        return this.money / divisor;
    }

    public double yield (int earning) {
        return earning * 100.0 / money;
    }

    private void numericFormat(String userInput) {
        if (!(IntegerValidation.isNumeric(userInput, IntConstant.ZERO_ASCII_CODE.getValue(),
                IntConstant.NINE_ASCII_CODE.getValue()))) {
            throw new IllegalArgumentException(StringConstant.MONEY_INPUT_NOT_NUMERIC_FORM_ERROR_MESSAGE.getMessage());
        }
    }

    private void divideByInteger(String userInput) {
        if (!(IntegerValidation.isDivideByInteger(userInput, IntConstant.LOTTO_MONEY_PER_ONE.getValue()))) {
            throw new IllegalArgumentException(StringConstant.MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE.getMessage());
        }
    }

}
