package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

import java.math.BigInteger;

public class BonusNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkOutOfTypeRange(input);
        checkOutOfRange(input);
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
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void checkOutOfRange(String input) {
        if (Long.parseLong(input) < Constant.START_INCLUSIVE ||
                Long.parseLong(input) > Constant.END_INCLUSIVE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
    }
}
