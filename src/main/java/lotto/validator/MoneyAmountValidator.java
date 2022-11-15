package lotto.validator;

import lotto.constant.ErrorMessage;

public class MoneyAmountValidator {
    public static void validateInputType(String userInput){
        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(ErrorMessage.MONEY_AMOUNT_WRONG_TYPE);
            }
        }
    }
}
