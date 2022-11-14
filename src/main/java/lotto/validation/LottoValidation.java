package lotto.validation;

import static lotto.constant.ErrorConstant.ERROR_NOT_VALID_MONEY;
import static lotto.constant.LottoConstant.LOTTO_BASE_PRICE;

public class LottoValidation {
    public static void canBuyLotto(int userMoney) {
        if (userMoney < LOTTO_BASE_PRICE || (userMoney % LOTTO_BASE_PRICE) != 0) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MONEY);
        }
    }
}
