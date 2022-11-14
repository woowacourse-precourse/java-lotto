package lotto.utils.validator;

import static lotto.utils.Exceptions.CAN_NOT_SPLIT;
import static lotto.utils.LottoInformation.SIX_LOTTO_PATTERN;

public class StringValidator {
    public static void checkSplitSixArgs(String input) {
        if (!input.matches(SIX_LOTTO_PATTERN)) {
            throw new IllegalArgumentException(CAN_NOT_SPLIT.toString());
        }
    }
}