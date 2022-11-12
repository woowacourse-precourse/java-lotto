package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";

    public int getInputAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int inputAmount = parseInt(Console.readLine());
        return validationInputAmount(inputAmount);
    }

    private int validationInputAmount(int inputAmount) {
        return inputAmount;
    }

    private String inputWinningNum() {
        System.out.println(INPUT_WINNING_NUM);
        return Console.readLine();
    }

    private int inputBonusNum() {
        System.out.println(INPUT_BONUS_NUM);
        return parseInt(Console.readLine());
    }
}
