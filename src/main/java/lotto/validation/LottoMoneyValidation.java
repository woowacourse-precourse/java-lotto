package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LottoMoneyValidation extends Validation{

    @Override
    public void isValidate(String userInput) {
        isNumericFormat(userInput);
        int money = Integer.parseInt(userInput);
        isDivideByInteger(money);
    }

    private void isNumericFormat(String userInput) {
        IntegerValidation integerValidation = new IntegerValidation();
        if (!(integerValidation.isNumeric(userInput, IntConstant.ZERO_ASCII_CODE.getValue(),
                IntConstant.NINE_ASCII_CODE.getValue()))) {
            createError(StringConstant.MONEY_INPUT_NOT_NUMERIC_FORM_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDivideByInteger(int money) {
        IntegerValidation integerValidation = new IntegerValidation();
        if (!(integerValidation.isDivideByInteger(money, IntConstant.LOTTO_MONEY_PER_ONE.getValue()))) {
            createError(StringConstant.MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE.getMessage());
        }
    }

}
