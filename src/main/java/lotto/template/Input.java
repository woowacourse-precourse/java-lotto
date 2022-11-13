package lotto.template;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static void insertMoney() {
        String input = readAfterPrint("구입금액을 입력해 주세요.");
    }

    public static void insertWinningNumbers() {
        String input = readAfterPrint("당첨 번호를 입력해 주세요.");
    }

    public static void insertBonusNumber() {
        String input = readAfterPrint("보너스 번호를 입력해 주세요.");
    }

    private static String readAfterPrint(String out) {
        System.out.println(out);
        return Console.readLine();
    }
}
