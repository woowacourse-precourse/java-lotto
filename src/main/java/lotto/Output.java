package lotto;

public class Output {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String WRITE_PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";
    private static final String STATISTIC_OUTPUT = "당첨 통계\n" + "---";

    public static void printPurchaseMoneyMessage() {
        System.out.println(INPUT_MONEY);
    }
    public static void printPurchaseCount(int num) {
        System.out.println("\n"+ num + WRITE_PURCHASE_COUNT);
    }

    public static void printWinningNumMessage() {
        System.out.println(INPUT_WINNING_NUM);
    }
    public static void printBonusNumMessage() {
        System.out.println(INPUT_BONUS_NUM);
    }

    public static void printWinningStatistic() {
        System.out.println(STATISTIC_OUTPUT);
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.2f",profit) + "%입니다.\n");
    }
}
