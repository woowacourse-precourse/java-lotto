package lotto.validate;

import static lotto.util.LottoGenerator.*;

public class UserValidator extends Validator {
    public static void validMoneyDividedLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위가 아닙니다.");
        }
    }
}
