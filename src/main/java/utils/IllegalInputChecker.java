package utils;

import messages.ExceptionMessages;

public class IllegalInputChecker {
    ExceptionMessages exceptionMessage;

    private static final String patternForNums = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
    private static final String patternForBonus = "^\\d{1,2}$";
    private static final String patternForPay = "[0-9]+";

    public void checkUserPayIllegal(String userPayment) {
        if (!userPayment.matches(patternForPay)) {
            throw new IllegalArgumentException(exceptionMessage.WRONG_PAYMENT);
        } if (Integer.parseInt(userPayment) <= 0 || Integer.parseInt(userPayment) % 1000 != 0) {
            throw new IllegalArgumentException(exceptionMessage.WRONG_PAYMENT);
        } if (userPayment.startsWith("0")) {
            throw new IllegalArgumentException(exceptionMessage.WRONG_PAYMENT_START_WITH_ZERO);
        }
    }

    public void checkUserInputIllegal(String userInput) {
        if (!userInput.matches(patternForNums)) {
            throw new IllegalArgumentException(exceptionMessage.WRONG_NUM);
        }
    }

    public void checkUserBonusIllegal(String userBonus) {
        if (!userBonus.matches(patternForBonus)) {
            throw new IllegalArgumentException(exceptionMessage.WRONG_BONUS);
        }
    }
}