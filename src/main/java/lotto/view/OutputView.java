package lotto.view;

public class OutputView {
    public static final String TICKET_COUNT = "개를 구매했습니다.";

    public static void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT);
    }

    public static void printSuccessResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}
