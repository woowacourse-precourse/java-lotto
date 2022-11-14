package lotto.validation;

import java.util.List;

import static lotto.constant.ErrorConstant.ERROR_NOT_VALID_COUNT;
import static lotto.constant.ErrorConstant.ERROR_NOT_VALID_MONEY;
import static lotto.constant.LottoConstant.LOTTO_BASE_PRICE;
import static lotto.constant.LottoConstant.LOTTO_COUNT_NUMBER;

public class LottoValidation {
    public static void canBuyLotto(int userMoney) {
        if (userMoney < LOTTO_BASE_PRICE || (userMoney % LOTTO_BASE_PRICE) != 0) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MONEY);
        }
    }
    public static void isValidLotto(List<Integer> lotto) {
        if (!checkCountOfNumbers(lotto)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_COUNT);
        }
    }

    private static boolean checkCountOfNumbers(List<Integer> lotto) {
        if (lotto.size() != LOTTO_COUNT_NUMBER) {
            return false;
        }
        return true;
    }

}
