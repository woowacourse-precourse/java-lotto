package lotto.view;

import lotto.domain.Amounts;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinStatistics;

import java.util.List;

import static lotto.domain.Rank.*;

public class Output {

    private static final List<Rank> rankTotal = List.of(FIFTH,
            FOURTH, SECOND, SECOND_BONUS, FIRST);

    public void printGeneratedLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        lottoList.forEach( lotto -> System.out.println(lotto.toString()));
    }

    public void printWinningHistory(Amounts amounts, List<Rank> ranks) {
        WinStatistics winStatistics = WinStatistics.calculateWinningAmount(amounts, ranks);

        System.out.println("당첨 통계");
        System.out.println("---");

        rankTotal.forEach(rank -> printStatistics(rank, winStatistics));

        printEarnRate(winStatistics);
    }

    private static void printStatistics(final Rank rank, final WinStatistics winStatistics) {
        if (rank == SECOND_BONUS) {
            printSecondBonusRank(rank, winStatistics);
            return;
        }
        printDefaultRank(rank, winStatistics);
    }

    private static void printSecondBonusRank(final Rank rank, final WinStatistics winStatistics) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                rank.getCount(), rank.getReward(), winStatistics.countPerRank(rank));
    }
    private static void printDefaultRank(final Rank rank, final WinStatistics winStatistics) {
        System.out.printf("%d개 일치 (%s원) - %d개",
                rank.getCount(), rank.getReward(), winStatistics.countPerRank(rank));
    }

    private static void printEarnRate(WinStatistics winStatistics) {
        System.out.printf("총 수익률은 %.1f%%입니다.", winStatistics.getEarnRate());
    }

}
