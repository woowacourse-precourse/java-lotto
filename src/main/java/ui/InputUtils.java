package ui;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String getMoneyFromUser() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }
}
