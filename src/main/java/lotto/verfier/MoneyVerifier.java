package lotto.verfier;

import lotto.util.ExceptionMessage;

import java.math.BigInteger;

public class MoneyVerifier implements Verifer {
    @Override
    public void check(String input) {

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
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
    }
}
