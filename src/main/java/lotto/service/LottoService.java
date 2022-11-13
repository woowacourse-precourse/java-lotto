package lotto.service;

import static lotto.LottoConstant.INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE;
import static lotto.LottoConstant.INPUT_IS_NOT_NUMBER_ERROR_MESSAGE;
import static lotto.LottoConstant.INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE;

public class LottoService {

    private LottoService() {
    }

    public static int amountInputToInteger(String input) {
        if (!input.chars().allMatch((Character::isDigit))) {
            throw new IllegalStateException(INPUT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        int amount = Integer.parseInt(input);
        if (amount < 1000) {
            throw new IllegalStateException(INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE);
        }
        if (amount % 1000 != 0) {
            throw new IllegalStateException(INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE);
        }

        return amount;
    }

    public static int getLottoPurchaseCount(int amount) {
        return amount / 1000;
    }
}
