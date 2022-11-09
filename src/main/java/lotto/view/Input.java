package lotto.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자에게 입력을 받는 책임을 가진 클래스
 */
public class Input {

    private final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public Input() {
    }

    public int getInputPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT);

        return Integer.parseInt(Console.readLine());
    }

    public String getInputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        return Console.readLine();
    }

    public int getInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        return Integer.parseInt(Console.readLine());
    }


}
