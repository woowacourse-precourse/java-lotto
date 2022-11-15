package lotto.ui.message;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum OutputMessageGenerator {
    INSTANCE;

    private static final String PURCHASE_LOTTO_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String RANK_RESULT_MESSAGE_FORMAT = "%d개 일치 (%s) - %d개";
    private static final String SECOND_RANK_RESULT_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s) - %d개";
    private static final DecimalFormat rewardFormat = new DecimalFormat("###,###");

    private static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

    public static String getPurchaseLottoMessage(int lottoCount) {
        return String.format(PURCHASE_LOTTO_MESSAGE_FORMAT, lottoCount);
    }

    public static String getLottoNumbersByAscendingOrder(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }

    public static List<String> getTotalRankCountMessage(Map<Rank, Integer> rankCounts) {
        List<Rank> ranksByReverseOrder = getRanksByReverseOrder();
        return ranksByReverseOrder.stream()
                .map(rank -> getRankCountMessage(rank, rankCounts.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
    }

    public static String getYieldMessage(String yield) {
        return String.format(YIELD_MESSAGE_FORMAT, yield);
    }

    private static String getRankCountMessage(Rank rank, int count) {
        int jackpotHitCnt = rank.getJackpotHitCnt();
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
