package lotto.verifier;

import lotto.util.Constant;
import lotto.util.ExceptionMessage;

import java.math.BigInteger;
import java.util.Arrays;

public class WinnerNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumberCount(input);
        checkEachNumeric(input);
        checkEachOutOfTypeRange(input);
        checkEachOutOfRange(input);
        checkEachDistinct(input);
    }

    private void checkNumberCount(String input) {
        if (input.split(",").length != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.COUNT_NOT_EQUAL);
        }
    }

    private void checkEachNumeric(String input) {
        String[] divided = input.split(",");
        try {
            Arrays.stream(divided).forEach(BigInteger::new);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.EACH_NOT_NUMERIC);
        }
    }
    private void checkEachOutOfTypeRange(String input) {
        String[] divided = input.split(",");
        try {
            Arrays.stream(divided).forEach(Long::parseLong);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void checkEachOutOfRange(String input) {
        if (Arrays.stream(input.split(","))
                .anyMatch(number -> Long.parseLong(number) < Constant.START_INCLUSIVE ||
                        Long.parseLong(number) > Constant.END_INCLUSIVE)
        )
        {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }
    }

    private void checkEachDistinct(String input) {
        int distinctCount = (int) Arrays.stream(input.split(","))
                .distinct()
                .count();
        int inputCount = (int) Arrays.stream(input.split(","))
                .count();
        if (distinctCount != inputCount) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_DISTINCT);
        }
    }
}
