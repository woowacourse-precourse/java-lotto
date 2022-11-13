package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.BANG)) {
                continue;
            }
            System.out.println(statisticsAtRank(winningStatistics, rank));
        }
    }

    public static void printYield(Money money, WinningStatistics winningStatistics) {
        double yield = money.calculateYield(winningStatistics.calculateTotalPrize());
        System.out.println("총 수익률은 " + formatYield(yield) + "%입니다.");
    }

    private static String statisticsAtRank(WinningStatistics winningStatistics, Rank rank) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", rank.getSameNumbersCount()));
        if (rank.hasBonusNumber()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%s원) - %d개", formatInteger(rank.getPrize()), winningStatistics.countWonLottosByRank(rank)));
        return sb.toString();
    }

    private static String formatInteger(Number number) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(number);
    }

    private static String formatYield(double yield) {
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        return formatter.format(yield);
    }
}
