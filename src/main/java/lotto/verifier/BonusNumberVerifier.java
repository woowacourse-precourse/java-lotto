package lotto.verifier;

import lotto.util.ExceptionMessage;

import java.math.BigInteger;

public class BonusNumberVerifier implements Verifier {
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
}
