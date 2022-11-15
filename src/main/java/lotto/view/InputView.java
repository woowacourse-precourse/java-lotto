package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String purchaseInput() {
        System.out.println(PURCHASE_MONEY);
        return Console.readLine();
    }
    public static String getWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS);
        return Console.readLine();
    }
    public static String getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }
}
