package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LottoMoneyValidation extends Validation{

    @Override
    public void isValidate(String userInput) {
        isNumericFormat(userInput);
        isDivideByInteger(userInput);
    }

    private void isNumericFormat(String userInput) {
        if (!(IntegerValidation.isNumeric(userInput, IntConstant.ZERO_ASCII_CODE,
                IntConstant.NINE_ASCII_CODE))) {
            createError(StringConstant.MONEY_INPUT_NOT_NUMERIC_FORM_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDivideByInteger(String userInput) {
        if (!(IntegerValidation.isDivideByInteger(userInput, IntConstant.LOTTO_MONEY_PER_ONE))) {
            createError(StringConstant.MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE.getMessage());
        }
    }

}
