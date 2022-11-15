package lotto.Utils.Validator;

import static lotto.Utils.Constant.*;

import lotto.Utils.Util;

public class BuyerValidator {


    private static final String NOT_INTEGER_STATE = "정수만 입력해야 합니다.";
    private static final String NOT_NATURAL_STATE = "양수만 입력해야 합니다.";
    private static final String NOT_1000UNIT_STATE = "1000원 단위로 입력해야 합니다.";

    protected final String money;

    public BuyerValidator(String money) {
        this.money = money;
        isInteger();
        isNatural();
        is1000Unit();
    }

    ;

    private void isInteger() {
        try {
            Util.getInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_STATE);
        }
    }

    private void isNatural() {
        if (Util.getInt(money) < 0) {
            throw new IllegalArgumentException(ERROR + NOT_NATURAL_STATE);
        }
    }

    private void is1000Unit() {
        if ((Util.getInt(money) % UNIT_OF_MONEY) != ZERO) {
            throw new IllegalArgumentException(ERROR + NOT_1000UNIT_STATE);
        }
    }

}
