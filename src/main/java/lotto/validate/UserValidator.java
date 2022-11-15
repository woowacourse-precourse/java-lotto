package lotto.validate;

import lotto.log.CustomLogger;

import static lotto.util.LottoGenerator.*;

public class UserValidator extends Validator {
    public static void validMoneyDividedLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            CustomLogger.LOG.severe("1000원 단위가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
}
