package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistic {
    public enum Ranking {
        FIRST(2_000_000_000, false),
        SECOND(30_000_000, true),
        THIRD(1_500_000, false),
        FOURTH(50_000, false),
        FIFTH(5_000, false),
        NONE(0, false);

        private final int prize;
        private final boolean hasBonus;

        Ranking(int prize, boolean hasBonus) {
            this.prize = prize;
            this.hasBonus = hasBonus;
        }

        public long getTotalWinning(int count) {
            return (long) prize * count;
        }
    }

    private final Map<Ranking, Integer> map = new EnumMap<>(Ranking.class);

    public WinningStatistic(IssuedLottos issuedLottos, WinningLotto winningLotto) {
        for (Lotto lotto : issuedLottos.getIssuedLotto()) {
            Ranking ranking = getRanking(lotto, winningLotto);
            map.put(ranking, map.getOrDefault(ranking, 0) + 1);
        }
    }

    public Map<Ranking, Integer> getMap() {
        return map;
    }

    private int countWinningNum(List<Integer> numbers, List<Integer> winningLotto) {
        int count = 0;
        for (Integer i : winningLotto) {
            if (numbers.contains(i)) {
                count += 1;
            }
        }
        return count;
    }

    private Ranking getRanking(Lotto lotto, WinningLotto winningLotto) {
        int count = countWinningNum(lotto.getNumbers(), winningLotto.getWinningLotto());

        if (count == 3) {
            return Ranking.FIFTH;
        }
        if (count == 4) {

            return Ranking.FOURTH;
        }
        if (count == 5) {
            if (lotto.getNumbers().contains(winningLotto.getBonusNum())) {
                return Ranking.SECOND;
            }
            return Ranking.THIRD;
        }
        if (count == 6) {
            return Ranking.FIRST;
        }
        return Ranking.NONE;
    }
}
