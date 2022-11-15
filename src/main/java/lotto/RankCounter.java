package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class RankCounter {

    private final Map<LottoRanking, Integer> rankCount;

    public RankCounter() {
        rankCount = new LinkedHashMap<>();
        for (LottoRanking rank: LottoRanking.values()) {
            if (rank.equals(LottoRanking.LOSE)) continue;
            rankCount.put(rank, 0);
        }
    }

    public void addRank(LottoRanking rank) {
        if (rank.equals(LottoRanking.LOSE)) return;
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public void showRankCount() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRanking rank : rankCount.keySet()) {
            System.out.println(rank + " - " + rankCount.get(rank) + "개");
        }
    }

    public long getTotalReword() {
        long totalReword = 0L;
        for (LottoRanking rank : rankCount.keySet()) {
            totalReword += rankCount.get(rank) * rank.getReward();
        }
        return totalReword;
    }
}
