package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningPrize;

import java.util.Map;

public class OutputView {
    public static void informPurchaseCount(Lottos lottos) {
        int count = lottos.countTotal();
        System.out.println(String.format("%d개를 구매했습니다.", count));
    }

    public static void printIssuedLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printWinningOverview(Lottos lottos, Lotto winningLotto, int bounsNumber) {
        Map<WinningPrize, Integer> winningCounts = lottos.countWinningPrize(winningLotto, bounsNumber);
        double profit = lottos.calculateProfit(winningLotto, bounsNumber);

        printOverViewIntro();
        printWinningCounts(winningCounts);
        printProfit(profit);
    }

    private static void printProfit(double profit) {
        System.out.print(String.format("총 수익률은 %.1f%%입니다.", profit));
    }

    private static void printWinningCounts(Map<WinningPrize, Integer> winningCounts) {
        System.out.println(String.format("3개 일치 (5,000원) - %d개", winningCounts.get(WinningPrize.FIFTH_PLACE)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", winningCounts.get(WinningPrize.FOURTH_PLACE)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", winningCounts.get(WinningPrize.THIRD_PLACE)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", winningCounts.get(WinningPrize.SECOND_PLACE)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", winningCounts.get(WinningPrize.FIRST_PLACE)));
    }

    private static void printOverViewIntro() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printErrorMessage(IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }
}
