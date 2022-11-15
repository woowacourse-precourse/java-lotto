package lotto.validate;

import lotto.LottoGenerator;
import lotto.log.CustomLogger;

public class UserValidator extends Validator {
    public static void validMoneyDividedLottoPrice(int money) {
        if (money % LottoGenerator.LOTTO_PRICE != 0) {
            CustomLogger.LOG.severe("1000원 단위가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }
}
