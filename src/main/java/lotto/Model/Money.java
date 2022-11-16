package lotto.Model;

import lotto.resources.Sentence;
import lotto.resources.Constants;
import lotto.resources.ExceptionCatcher;

public class Money {

    private static String moneyInput;

    public Money(String moneyInput) {
        validateMoneyInput(moneyInput.trim());
        this.moneyInput = moneyInput.trim();
    }

    public static long getLottoCntForCalculate() {
        return Long.parseLong(moneyInput) / 1000;
    }

    public static String HowManyLottosToPrint() {
        return (String.format(Sentence.YOU_PURCHASED.getValue(),
                Long.parseLong(moneyInput) / Constants.CURRENCY.getValue()));
    }

    private static void validateMoneyInput(String moneyInput) {
        if (checkDigits(moneyInput) != Constants.ERROR_CASE.getValue() &&
                checkValidNumber(moneyInput) != Constants.ERROR_CASE.getValue()) {
            checkDivideThousands(moneyInput);
        }
    }

    private static int checkDigits(String moneyInput) {
        try {
            Long.parseLong(moneyInput);
        } catch (NumberFormatException ex) {
            try {
                throw new IllegalArgumentException(Sentence.MONEY_NOT_NUMERIC.getValue());
            } catch (IllegalArgumentException e) {
                throw new ExceptionCatcher(Sentence.MONEY_NOT_NUMERIC.getValue());
            }
        }
        return Constants.CORRECT_CASE.getValue();
    }

    private static int checkValidNumber(String moneyInput) {
        try {
            if (Long.parseLong(moneyInput) < Constants.ZERO.getValue()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.MONEY_NOT_VALID.getValue());
        }
        return Constants.CORRECT_CASE.getValue();
    }

    private static int checkDivideThousands(String moneyInput) {
        try {
            if (Long.parseLong(moneyInput) % Constants.CURRENCY.getValue() != Constants.ZERO.getValue()) {
                throw new IllegalArgumentException(Sentence.MONEY_NOT_DIVIDED.getValue());
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionCatcher(Sentence.MONEY_NOT_DIVIDED.getValue());
        }
        return Constants.CORRECT_CASE.getValue();
    }
}