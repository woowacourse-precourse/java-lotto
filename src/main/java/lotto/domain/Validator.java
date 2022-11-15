package lotto.domain;

import lotto.util.ErrorMessage;

public class Validator {
    public static int validateMoney(String amount) {
        checkOnlyNumber(amount);
        checkMoneyUnit(amount);
        return Integer.valueOf(amount);
    }

    public static void validateLotto(String number) {

    }

    // 숫자로만 이루어졌는지 확인
    public static void checkOnlyNumber(String money) {
        try {
            int amount = Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.printMessage());
        }
    }

    // 1000원 단위인지 확인
    public static void checkMoneyUnit(String money) {
        int amount = Integer.parseInt(money);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_UNIT.printMessage());
        }
    }
}
