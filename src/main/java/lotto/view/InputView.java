package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMS_INPUT_MESSAGE = System.lineSeparator() + "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUM_INPUT_MESSAGE = System.lineSeparator() + "보너스 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNums() {
        System.out.println(WINNING_NUMS_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNum() {
        System.out.println(BONUS_NUM_INPUT_MESSAGE);
        return Console.readLine();
    }
}
