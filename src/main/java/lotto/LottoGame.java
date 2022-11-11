package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String INPUT_MONEY_ERROR_MESSAGE = "[ERROR] 금액을 1000원 단위로 입력해주세요.";

    public int countLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_ERROR_MESSAGE);
        }
        return money / 1000;
    }

    public int inputMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }
}
