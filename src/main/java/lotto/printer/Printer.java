package lotto.printer;

public class Printer {
    private static final int FIVE_MATCH_BALL = 5;
    private static final String PURCHASE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDER_LINE = "---";
    private static final String MATCH_NUMBER_RESULT = "%d개 일치";
    private static final String MATCH_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String MATCH_RESULT = " (%d원) - %d개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f입니다.";

    public static void requestPurchase() {
        System.out.println(PURCHASE_REQUEST_MESSAGE);
    }

    public static void printNumberOfTickets(int numberOfTickets) {
        System.out.printf(PURCHASE_MESSAGE, numberOfTickets);
    }

    public static void requestWinningNumber() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }

    public static void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }


}
