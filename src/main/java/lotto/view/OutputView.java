package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class OutputView {
    public static final String PRIZE_PATTERN = "###,###";
    public static final String YILED_PATTERN = "###,###.0";

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
        System.out.println("총 수익률은 " + formatNumber(yield, YILED_PATTERN) + "%입니다.");
    }

    private static String statisticsAtRank(WinningStatistics winningStatistics, Rank rank) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", rank.getSameNumbersCount()));
        if (rank.hasBonusNumber()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%s원) - %d개", formatNumber(rank.getPrize(), PRIZE_PATTERN), winningStatistics.countWonLottosByRank(rank)));
        return sb.toString();
    }

    private static String formatNumber(Number number, String pattern) {
        DecimalFormat formatter = new DecimalFormat(pattern);
        return formatter.format(number);
    }
}
