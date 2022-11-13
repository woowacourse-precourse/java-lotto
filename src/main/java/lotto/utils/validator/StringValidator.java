package lotto.utils.validator;

import lotto.utils.Error;

import static lotto.utils.LottoInformation.LOTTO_SELECTION_COUNT;

public class StringValidator {
    public static void checkSplitSixArgs(String[] input) {
        if (input.length != LOTTO_SELECTION_COUNT) {
            System.out.println(Error.CAN_NOT_SPLIT);
            throw new IllegalArgumentException();
        }
    }
}
