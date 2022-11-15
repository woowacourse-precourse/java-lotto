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

    public static void validateMoneyAmount(int moneyAmount){
        validateMoneyLessThanThousand(moneyAmount);
        validateMoneyModThousand(moneyAmount);
    }

    private static void validateMoneyLessThanThousand(int moneyAmount){
        if (moneyAmount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_AMOUNT_CANNOT_BUY_LOTTO);
        }
    }

    private static void validateMoneyModThousand(int moneyAmount){
        if (moneyAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_AMOUNT_WRONG_VALUE);
        }
    }
}
