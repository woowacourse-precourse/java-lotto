package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final static String ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private final static String ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String submitPayment() {
        return messageBox(ENTER_PURCHASE_PRICE);
    }

    public static final String submitWinningNumbers() {
        return messageBox(ENTER_WINNING_NUMBERS);
    }

    public static final String submitBonusNumber() {
        return messageBox(ENTER_BONUS_NUMBER);
    }

    public static final String messageBox(String message) {
        System.out.println(message);
        String inputValue = Console.readLine();
        System.out.println();
        return inputValue;
    }
}
