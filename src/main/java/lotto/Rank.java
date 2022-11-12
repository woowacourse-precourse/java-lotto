package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rank {
    enum Grade {
        THREE(3, 5000, false),
        FOUR(4, 50000, false),
        FIVE(5, 1500000, false),
        FIVE_BONUS(5, 30000000, true),
        SIX(6, 2000000000, false);

        private final int matchCount;
        private final long prize;
        private final boolean check;

        Grade(int matchCount, long prize, boolean check) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.check = check;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public long getPrize() {
            return prize;
        }

        public boolean isCheck() {
            return check;
        }
    }

    public static List<Integer> findMatchRank(Lotto winningNumbers, List<Lotto> lottoList, int bonusNumber) {
        List<Integer> matchRank = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            int rankKey = lotto.compareNumbers(winningNumbers, lotto);
            if (rankKey == 5 && lotto.hasBonusNumber(bonusNumber, lotto)) {
                matchRank.add(7);
                continue;
            }
            matchRank.add(rankKey);
        }
        return matchRank;
    }

    public static Map<Integer, Integer> getRankResult(List<Integer> matchRank) {
        Map<Integer, Integer> rankResult = new TreeMap<>();
        for (Integer rank : matchRank) {
            if (rank > 2) {
                rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
            }
        }
        return rankResult;
    }

}
