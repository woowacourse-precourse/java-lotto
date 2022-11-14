package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int MINIMUM_MONEY_VALUE = 1000;
    private static final int MONEY_UNIT = 1000;
    private static final String LOTTO_MONEY_IS_UNDER_MINIMUM_MONEY_VALUE = "[ERROR] 로또 구입 금액이 1000원 이하입니다.";
    private static final String LOTTO_MONEY_IS_NOT_DIVIDED_BY_MONEY_VALUE = "[ERROR] 로또 구입 금액이 1000원으로 나누어 떨어지지 않습니다.";

    public static Integer inputMoney() {
        int money = Integer.parseInt(Console.readLine());
        validateMoneyValue(money);
        return money;
    }

    private static int validateMoneyValue(int money) {
        if (money < MINIMUM_MONEY_VALUE) {
            throw new IllegalArgumentException(LOTTO_MONEY_IS_UNDER_MINIMUM_MONEY_VALUE);
        }
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(LOTTO_MONEY_IS_NOT_DIVIDED_BY_MONEY_VALUE);
        }
        return money;
    }
}