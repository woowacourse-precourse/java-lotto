package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;

public class LottoBuyer {

    public static final LottoBuyer getInstance = new LottoBuyer();

    public int getPay(String input) {

        checkOnlyNumber(input);
        checkPayUnit(input);

        return Integer.parseInt(input);
    }

    private void checkPayUnit(String input) {
        int money = changeInt(input);
        if (money % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }

    private void checkOnlyNumber(String input) {
        if (!input.matches(Constant.INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private int changeInt(String input) {
        return Integer.parseInt(input);
    }
}
