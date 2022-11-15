package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

import java.math.BigInteger;

public class MoneyVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkOutOfTypeRange(input);
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

    private void checkOutOfTypeRange(String input) {
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
