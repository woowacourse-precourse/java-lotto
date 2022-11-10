package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionConstants;
import lotto.validator.InputValidator;

public class InputUtil {

    public static final int LOTTO_PRICE = 1000;

    public static long inputLottoPurchaseAmount() {

        long purchasePrice = Long.parseLong(Console.readLine());

        if (InputValidator.isZero(purchasePrice)) {
            throw new IllegalArgumentException(ExceptionConstants.CANNOT_INPUT_ZERO);
        }

        if (InputValidator.restEqualZero(purchasePrice, LOTTO_PRICE)) {
            throw new IllegalArgumentException(ExceptionConstants.CAN_ONLY_MULTIPLY_1000);
        }

        return purchasePrice;
    }
}
