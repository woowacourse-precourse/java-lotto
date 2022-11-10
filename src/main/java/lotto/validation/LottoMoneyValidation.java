package lotto.validation;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;

public class LottoMoneyValidation extends Validation{

    @Override
    public void isValidate(String userInput) {
        isContainsDot(userInput);
        int money = Integer.parseInt(userInput);
        isDivideByInteger(money);
    }

    private void isContainsDot(String money) {
        if (money.contains(".")) {
            createError(StringConstant.MONEY_INPUT_NOT_INTEGER_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDivideByInteger(int money) {
        if (money % IntConstant.LOTTO_MONEY_PER_ONE.getValue() != 0) {
            createError(StringConstant.MONEY_INPUT_NOT_DIVIDE_BY_LOTTO_MONEY_PER_ONE_MESSAGE.getMessage());
        }
    }

}
