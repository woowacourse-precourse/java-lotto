package lotto.view;

import lotto.utils.ConsoleLog;

public class InputConsole {
    private static final ConsoleLog consolelog = ConsoleLog.getInstance();
    private static final String LINE = "\r\n";

    public static String enterWinningNumber() {
        consolelog.println(LINE + "당첨 번호를 입력해 주세요.");
        return consolelog.input();
    }

    public static String enterBonusNumber() {
        consolelog.println(LINE + "보너스 번호를 입력해 주세요.");
        return consolelog.input();
    }

    public static String enterPurchaseAmount() {
        consolelog.println("구입금액을 입력해 주세요.");
        return consolelog.input();
    }
}
