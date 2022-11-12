package utils;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static String getMoneyFromUser() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String getWinNumbersFromUser() {
        System.out.println(WIN_NUMBERS_INPUT_MESSAGE);
        return Console.readLine();
    }
}
