package lotto.view;

import lotto.domain.Amounts;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinStatistics;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.domain.Rank.*;

public class Output {

    private static final List<Rank> rankTotal = List.of(FIFTH,
            FOURTH, SECOND, SECOND_BONUS, FIRST);
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printGeneratedLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        lottoList.forEach( lotto -> System.out.println(lotto.toString()));
    }

    public void printWinningHistory(WinStatistics winStatistics) {

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
        int reward = rank.getReward();
        String rewardFormat = decimalFormat.format(reward);
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                rank.getCount(), rewardFormat, winStatistics.countPerRank(rank));
    }
    private static void printDefaultRank(final Rank rank, final WinStatistics winStatistics) {
        int reward = rank.getReward();
        String rewardFormat = decimalFormat.format(reward);
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                rank.getCount(), rewardFormat, winStatistics.countPerRank(rank));
    }

    private static void printEarnRate(WinStatistics winStatistics) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", winStatistics.getEarnRate());
    }

}
