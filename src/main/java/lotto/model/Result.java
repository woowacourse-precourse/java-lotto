package lotto.model;

import lotto.util.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> rankCounts = new HashMap<>(Map.of(
            Rank.FIFTH, 0, Rank.FORTH, 0,
            Rank.THIRD, 0, Rank.SECOND, 0,
            Rank.FIRST, 0));
    private final double rateOfReturn;

    public Result(int inputMoney, Lottos lottos, Lotto winningNumbers, int bonusNumber) {
        calcRankCounts(lottos, winningNumbers, bonusNumber);
        long totalPrize = 0L;

        for (Rank rank : rankCounts.keySet()) {
            int rankCount = rankCounts.get(rank);
            totalPrize += ((long) rank.getPrize()) * rankCount;
        }

        rateOfReturn = Math.round(((double) totalPrize / inputMoney) * 1000) / 10.0;
    }

    private void calcRankCounts(Lottos lottos, Lotto winningNumbers, int bonusNumber) {
        for (int i = 0, quantity = lottos.getQuantity(); i < quantity; i++) {
            Lotto lotto = lottos.getLotto(i);
            int matchCount = lotto.matchWithWinningNumber(winningNumbers);
            Rank rank = Rank.getRankByMatchCount(matchCount, lotto.contains(bonusNumber));

            if (rank != Rank.NONE) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("당첨 통계\n---\n");
        List<Rank> ranks = new ArrayList<>(rankCounts.keySet());
        ranks.sort(Rank::compareTo);

        for (Rank rank : ranks) {
            sb.append(rank).append(" - ").append(rankCounts.get(rank)).append("개\n");
        }

        sb.append("총 수익률은 ").append(String.format("%.1f", rateOfReturn)).append("%입니다.");

        return sb.toString();
    }
}
