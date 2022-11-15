package lotto.view;

public class InputView {

    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY);
    }

    public static void printInputWinningNumbers() {
        addNewLine();
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonusNumber() {
        addNewLine();
        System.out.println(INPUT_BONUS_NUMBER);
    }

    private static void addNewLine() {
        System.out.println();
    }
}
