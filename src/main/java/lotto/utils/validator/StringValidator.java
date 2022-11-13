package lotto.utils.validator;

import lotto.utils.Error;

import static lotto.utils.LottoInformation.SIX_LOTTO_PATTERN;

public class StringValidator {
    public static void checkSplitSixArgs(String input) {
        if (input.matches(SIX_LOTTO_PATTERN)) {
            System.out.println(Error.CAN_NOT_SPLIT);
            throw new IllegalArgumentException();
        }
    }
}