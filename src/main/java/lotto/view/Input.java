package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String ENTER_PURCHASE_COST = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private static String input() {
        return Console.readLine();
    }

    public static String inputCost() {
        System.out.println(ENTER_PURCHASE_COST);
        return input();
    }

    public static String inputWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        return input();
    }

    public static String inputBonusNumbers() {
        System.out.println(ENTER_BONUS_NUMBER);
        return input();
    }
}
