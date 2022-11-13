package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public enum TotalResult {

    INSTANCE;
    public static Map<Rank, Integer> getRankCounts(JackpotBonus jackpotBonus, List<Lotto> lotteries) {
        Map<Rank, Integer> rankCounts = new EnumMap<Rank, Integer>(Rank.class);

        for (Lotto lotto : lotteries) {
            Rank rankOfLotto = jackpotBonus.getRankOf(lotto);
            int currentCnt = rankCounts.getOrDefault(rankOfLotto, 0);
            rankCounts.put(rankOfLotto, currentCnt + 1);
        }
        return rankCounts;
    }
}
