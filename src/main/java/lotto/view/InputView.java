package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String PLAYER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String WINNIG_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String playerMoney() {
        System.out.println(PLAYER_MONEY_MESSAGE);

        String playerMoney = Console.readLine();
        return playerMoney;
    }

    public static String winningNumbers() {
        System.out.println(WINNIG_NUMBER_MESSAGE);

        String winnigNumbers = Console.readLine();
        return winnigNumbers;
    }
}
