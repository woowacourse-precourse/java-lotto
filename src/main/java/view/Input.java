package view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER = "당첨번호를 입력해 주세요.";
    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String inputWinNumber() {
        System.out.println();
        System.out.println(WIN_NUMBER);
        return Console.readLine();
    }
    public static String bonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
