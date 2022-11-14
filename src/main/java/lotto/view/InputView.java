package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LINE_BREAK = "\n";
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(LINE_BREAK + INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(LINE_BREAK + INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
