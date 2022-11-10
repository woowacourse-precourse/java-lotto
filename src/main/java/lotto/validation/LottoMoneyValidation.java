package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LottoMoneyValidation extends Validation{

    @Override
    public void isValidate(String userInput) {
        isNumeric(userInput);
        int money = Integer.parseInt(userInput);
        isMinusValue(money);
        isDivideByInteger(money);
    }

    private void isNumeric(String userInput) {
        if (userInput.length() != userInput.chars()
                .filter(this::isNumber)
                .count()) {
            createError(StringConstant.MONEY_INPUT_NOT_NUMERIC_FORM_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNumber(int inputChar) {
        return IntConstant.ZERO_ASCII_CODE.getValue() <= inputChar
                && inputChar <= IntConstant.NINE_ASCII_CODE.getValue();
    }

    private void isMinusValue(int money) {
        if (money < 0) {
            createError(StringConstant.MONEY_INPUT_MINUS_VALUE_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDivideByInteger(int money) {
        if ((money % IntConstant.LOTTO_MONEY_PER_ONE.getValue()) != 0) {
            createError(StringConstant.MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE.getMessage());
        }
    }

}
