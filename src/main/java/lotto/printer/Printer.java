package lotto.printer;

import java.util.HashMap;

public class Printer {

    private static final HashMap<Integer, String> prize = new HashMap<>() {{
        put(3, "5,000");
        put(4, "50,000");
        put(5, "1,500,000");
        put(6, "2,000,000,000");
        put(7, "30,000,000");
    }};

    private static final int FIVE_MATCH_BALL = 5;
    private static final String PURCHASE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDER_LINE = "---";
    private static final String MATCH_NUMBER_RESULT = "%d개 일치";
    private static final String MATCH_BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String MATCH_RESULT = " - %d개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f"+"%%"+"입니다.";

    public static void requestPurchase() {
        System.out.println(PURCHASE_REQUEST_MESSAGE);
    }

    public static void printNumberOfTickets(int numberOfTickets) {
        System.out.printf(PURCHASE_MESSAGE, numberOfTickets);
        System.out.println();
    }

    public static void requestWinningNumber() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }

    public static void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDER_LINE);
    }

    public static void printResult(String message, Integer count) {
        System.out.print(message);
        System.out.printf(MATCH_RESULT, count);
    }

    public static void printEarningRate(Float money) {
        System.out.printf(EARNING_RATE_MESSAGE, money);
    }
}
