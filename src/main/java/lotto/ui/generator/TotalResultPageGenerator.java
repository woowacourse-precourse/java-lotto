package lotto.ui.generator;

import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum TotalResultPageGenerator {
    INSTANCE;

    private static final String RANK_RESULT_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_RANK_RESULT_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final DecimalFormat rewardFormat = new DecimalFormat("###,###");

    private static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

    public static List<String> getTotalRankCountMessage(Map<Rank, Integer> rankCounts) {
        java.util.List<Rank> ranksByReverseOrder = getRanksByReverseOrder();
        return ranksByReverseOrder.stream()
                .map(rank -> getRankCountMessage(rank, rankCounts.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
    }

    public static String getYieldMessage(String yield) {
        return String.format(YIELD_MESSAGE_FORMAT, yield);
    }

    private static String getRankCountMessage(Rank rank, int count) {
        int jackpotHitCnt = rank.getJackpotCriteriaCnt();
        String reward = rewardFormat.format(rank.getReward());

        if (rank == Rank.SECOND) {
            return String.format(SECOND_RANK_RESULT_MESSAGE_FORMAT, jackpotHitCnt, reward, count);
        }
        return String.format(RANK_RESULT_MESSAGE_FORMAT, jackpotHitCnt, reward, count);
    }

    private static List<Rank> getRanksByReverseOrder() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NO_LUCK)
                .sorted(Comparator.comparing(Rank::getRankNumber).reversed())
                .collect(Collectors.toList());
    }
}
