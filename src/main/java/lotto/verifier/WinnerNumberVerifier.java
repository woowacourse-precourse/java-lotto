package lotto.verifier;

import lotto.util.Constant;
import lotto.util.ExceptionMessage;

import java.math.BigInteger;
import java.util.Arrays;

public class WinnerNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
    }

    private void checkNumberCount(String input) {
        if (input.split(",").length != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_COUNT_NOT_EQUAL);
        }
    }

    private void checkEachNumeric(String input) {
        String[] divided = input.split(",");
        try {
            Arrays.stream(divided).forEach(BigInteger::new);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_NOT_NUMBER);
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
        if(Arrays.stream(input.split(","))
                .allMatch(number -> Long.parseLong(number) < Constant.START_INCLUSIVE ||
                        Long.parseLong(number) > Constant.END_INCLUSIVE)
        )
        {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }
    }
}
