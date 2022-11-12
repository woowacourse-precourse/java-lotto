package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READ_USER_PAID_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String readUserPaidMoney() {
        System.out.println(READ_USER_PAID_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.println(READ_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
