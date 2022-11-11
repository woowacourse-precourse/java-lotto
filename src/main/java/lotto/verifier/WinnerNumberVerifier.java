package lotto.verifier;

import lotto.util.Constant;
import lotto.util.ExceptionMessage;

public class WinnerNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
    }

    private void checkNumberCount(String input) {
        if (input.split(",").length != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_COUNT_NOT_EQUAL);
        }
    }
}
