package lotto.UI;

import java.util.List;
import lotto.domain.Lotto;

public class Output {

    public static void printLotteries(List<Lotto> lotteries) {
        System.out.println();
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
    }

    public static void printWinningStatistics(String resultPrintFormat, float earningRate) {
        printResult(resultPrintFormat);
        printEarningRate(earningRate);
    }

    private static void printResult(String resultPrintFormat) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf(resultPrintFormat);
    }

    private static void printEarningRate(float earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
        System.out.println();
    }
}
