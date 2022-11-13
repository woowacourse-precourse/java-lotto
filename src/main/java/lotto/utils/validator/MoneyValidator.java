package lotto.utils.validator;

import lotto.utils.Error;

import static lotto.utils.LottoInformation.LOTTO_PRICE;

public class MoneyValidator {
    public static void checkUnitOf1000Won(int money) {
        if (money % LOTTO_PRICE > 0) {
            System.out.println(Error.NOT_UNIT_OF_1000_WON);
            throw new IllegalArgumentException();
        }
    }
}
