package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoBuyer {

    public static final LottoBuyer getInstance = new LottoBuyer();
    private static final String INT_REGEX = "^[0-9]*$";

    public int getPay() {
        String input = Console.readLine();

        checkOnlyNumber(input);
        checkPayUnit(input);

        return Integer.parseInt(input);
    }

    public void checkPayUnit(String input) {
        int money = changeInt(input);
        if (money % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000 단위로만 입력 가능합니다.");
        }
    }

    public void checkOnlyNumber(String input) {
        if (!input.matches(INT_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private int changeInt(String input) {
        return Integer.parseInt(input);
    }
}
