package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MESSAGE_MONEY_INPUT = "구입금액을 입력해주세요.";

    public static String getMoneyInput() {
        OutputView.printString(MESSAGE_MONEY_INPUT);
        return Console.readLine();
    }
}
