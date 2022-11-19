package lotto.view;

import java.text.MessageFormat;

public enum InputView {

    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요.");

    private final String message;

    InputView(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static void printInputWinningNumbers() {
        System.out.println(MessageFormat.format("\n{0}", INPUT_WINNING_NUMBERS));
    }

    public static void printInputBonusNumber() {
        System.out.println(MessageFormat.format("\n{0}", INPUT_BONUS_NUMBER));
    }

}
