package lotto.verifier;

import lotto.util.Constant;
import lotto.util.ExceptionMessage;

import java.math.BigInteger;

public class MoneyVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkOutOfRange(input);
        checkPositive(input);
        checkDivisible(input);
    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    private void checkOutOfRange(String input) {
        try {
            Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
    }

    private void checkPositive(String input) {
        if (Long.parseLong(input) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_POSITIVE);
        }
    }

    private void checkDivisible(String input) {
        if (Long.parseLong(input) % Constant.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIVISIBLE);
        }
    }
}
