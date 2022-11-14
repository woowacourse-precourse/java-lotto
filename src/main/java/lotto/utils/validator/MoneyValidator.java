package lotto.utils.validator;

import static lotto.utils.Exceptions.NOT_UNIT_OF_1000_WON;
import static lotto.utils.LottoInformation.LOTTO_PRICE;

public class MoneyValidator {
    public static void checkUnitOf1000Won(int money) {
        if (money % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(NOT_UNIT_OF_1000_WON.toString());
        }
    }
}