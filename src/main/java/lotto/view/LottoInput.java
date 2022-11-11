package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInput {
    private static final String INPUT_PAY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPayMoney() {
        System.out.println(INPUT_PAY_MONEY);

        String payMoney = Console.readLine();
        return payMoney;
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        String winningNumber = Console.readLine();
        return winningNumber;
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
