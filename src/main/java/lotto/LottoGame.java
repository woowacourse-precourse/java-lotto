package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    public int inputMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }
}
