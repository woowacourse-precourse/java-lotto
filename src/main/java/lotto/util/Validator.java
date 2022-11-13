package lotto.util;

import lotto.constant.Constant;

public class Validator {

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isLottoMoney(int money){
        return money % Constant.LOTTO_PRICE == 0;
    }
}
