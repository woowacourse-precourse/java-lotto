package lotto.verifier;

import lotto.domain.Lotto;
import lotto.util.Constant;
import lotto.util.ExceptionMessage;

import java.math.BigInteger;

public class BonusNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkOutOfTypeRange(input);
        checkOutOfRange(input);
    }

    // 로직 관련 서비스이기 때문에 나중에 보너스 객체에 넣을 듯!
//    private void checkExistInWinnerVerifier(String input, Lotto winnerLotto) {
//        if (winnerLotto.contains(Long.parseLong(input))) {
//            throw new IllegalArgumentException();
//        }
//    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOutOfTypeRange(String input) {
        try {
            Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOutOfRange(String input) {
        if (Long.parseLong(input) < Constant.START_INCLUSIVE ||
                Long.parseLong(input) > Constant.END_INCLUSIVE) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
    }
}
