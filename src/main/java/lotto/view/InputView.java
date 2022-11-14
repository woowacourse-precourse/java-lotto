package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputUserMoney() {
        printRequestMoneyInputMessage();
        return Console.readLine();
    }

    private static void printRequestMoneyInputMessage() {
        System.out.println(REQUEST_MONEY_MESSAGE);
    }
}
