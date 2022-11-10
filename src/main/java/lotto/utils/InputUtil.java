package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class InputUtil {

    public static final int LOTTO_PRICE = 1000;

    public static long inputLottoPurchaseAmount() {

        while (true) {
            long purchasePrice = Long.parseLong(Console.readLine());

            if (!InputValidator.isZero(purchasePrice) &&
                    InputValidator.restEqualZero(purchasePrice, LOTTO_PRICE)) {
                return purchasePrice;
            }
        }
    }
}
