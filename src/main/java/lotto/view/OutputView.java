package lotto.view;

public class OutputView {

    private static final String LINE_FEED = "\n";
    private static final int pourcentage = 100;

    private static final String READ_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String PRINT_PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_EARNING_START_MESSAGE = "총 수익률은 ";
    private static final String PRINT_EARNING_END_MESSAGE = "%입니다.";

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

    public static void printEarning(double earning) {
        System.out.print(PRINT_EARNING_START_MESSAGE);
        System.out.printf("%.1f", earning * pourcentage);
        System.out.print(PRINT_EARNING_END_MESSAGE);
    }
}
