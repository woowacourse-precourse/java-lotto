package view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {
    private static final String INPUT_PURCHASE_AMOUNT = "구매 금액 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
