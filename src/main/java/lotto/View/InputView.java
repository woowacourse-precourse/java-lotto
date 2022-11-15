package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public int inputPurchasing() {
        System.out.println(INPUT_PURCHASING_AMOUNT);
        String purchasingAmountUserInput = Console.readLine();
        int purchasingAmount = Integer.parseInt(purchasingAmountUserInput);
        return purchasingAmount;
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumberUserInput = Console.readLine();

        return winningNumberUserInput;
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumberUserInput = Console.readLine();

        return bonusNumberUserInput;
    }
}
