package lotto.domain.lotto.verifier;

import static lotto.global.constant.VerifierConstants.*;

public class InputMoneyVerifier {

    public static String inputMoneyVerifier(String inputMoney) {
        isMoneyOnlyNumber(inputMoney);
        isMoneyDividedBy1000(inputMoney);
        return inputMoney;
    }

    private static void isMoneyDividedBy1000(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + ONLY_UNIT_1000);
        }
    }

    private static void isMoneyOnlyNumber(String inputMoney) {
        if (!inputMoney.matches(ONLY_NUMBER_REGEXP)) {
            throw new IllegalArgumentException(ERROR + ONLY_INPUT_NUMBER);
        }
    }
}
