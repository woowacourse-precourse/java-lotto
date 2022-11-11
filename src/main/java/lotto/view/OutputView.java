package lotto.view;

public class OutputView {

    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n" + "---";

    public static void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public static void printInputAnswerNumbers() {
        System.out.println(INPUT_ANSWER_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }
}
