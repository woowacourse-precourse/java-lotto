package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    static final String LINE_BREAK = "\n";

    public static String receivePurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();

        return purchaseAmount;
    }

    public static String receiveWinningNumber() {
        System.out.println(LINE_BREAK + INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();

        return winningNumber;
    }
}
