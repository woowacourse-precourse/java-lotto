package lotto.view;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String INPUT_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.\n";
    private static final String INPUT_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.\n";

    public static void printInputMoney() {
        System.out.printf(INPUT_MONEY_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.printf(INPUT_NUMBER_MESSAGE);
    }

    public static void printInputBonus() {
        System.out.printf(INPUT_BONUS_MESSAGE);
    }
}
