package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole {

    public static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int purchaseMoney() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        int money = Integer.parseInt(Console.readLine());
        return money;
    }
}
