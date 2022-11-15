package lotto;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String RANK_STATISTICS_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String TOTAL_EARNING_RATIO_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String SECOND_REWARD_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String COMMON_REWARD_MESSAGE = "%d개 일치 (%s원) - %d개";

    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, lottoCount));
    }

    public static void printLotto(String lotto) {
        System.out.println(lotto);
    }

    public static void printRankStatistics(Map<Rank, Integer> statistics) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(RANK_STATISTICS_MESSAGE);
        System.out.println(HYPHEN);
        for (Rank rank : statistics.keySet()) {
            if (rank == Rank.NO_RANK) {
                continue;
            }
            if (rank.containBonus()) {
                System.out.println(String.format(SECOND_REWARD_MESSAGE, rank.getMatchCount(), decimalFormat.format(rank.getReward()), statistics.get(rank)));
            }
            System.out.println(String.format(String.format(COMMON_REWARD_MESSAGE, rank.getMatchCount(), decimalFormat.format(rank.getReward()), statistics.get(rank))));
        }
    }

    public static void printEarningRatio(String earningRatio) {
        System.out.printf((TOTAL_EARNING_RATIO_MESSAGE) + "%n", earningRatio);
    }
}