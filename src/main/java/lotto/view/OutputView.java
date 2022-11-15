package lotto.view;

public class OutputView {

    private static final String LINE_FEED = "\n";

    private static final String READ_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String PRINT_PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";

    public static String getReadInputMessage() {
        return READ_INPUT_MESSAGE;
    }

    public static String getReadWinningNumbersMessage() {
        return LINE_FEED + READ_WINNING_NUMBERS_MESSAGE;
    }

    public static String getReadBonusNumberMessage() {
        return LINE_FEED + READ_BONUS_NUMBER_MESSAGE;
    }

    public static void printPurchaseNum(int number) {
        System.out.println(LINE_FEED + number + PRINT_PURCHASE_NUM_MESSAGE);
    }
}
