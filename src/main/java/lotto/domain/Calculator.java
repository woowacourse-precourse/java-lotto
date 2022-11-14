package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private static final Integer COUNT_INIT = 0;

    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public Calculator(WinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, COUNT_INIT);
        }
        calculate(winningNumbers, lottos);
    }

    private void calculate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(winningNumbers, lotto);
            Integer count = rankCounts.get(rank);
            rankCounts.put(rank, count + 1);
        }
    }

    public static Rank calculateRank(WinningNumbers winningNumbers, Lotto lotto) {
        int count = getWinningNumberMatch(winningNumbers, lotto);
        if (getWinningNumberMatch(winningNumbers, lotto) == 5 && hasNotBonus(winningNumbers, lotto)) {
            return Rank.THIRD;
        }
        return getRankByMatch(count);
    }

    private static int getWinningNumberMatch(WinningNumbers winningNumbers, Lotto lotto) {
        int count = COUNT_INIT;
        for (Integer number : winningNumbers.getWinningNumbers().getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public static Rank getRankByMatch(int match) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatch() == match) {
                return rank;
            }
        }
        return Rank.NOTHING;
    }

    public static boolean hasNotBonus(WinningNumbers winningNumbers, Lotto lotto) {
        return !lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    public int getTotalPrice() {
        int total = COUNT_INIT;
        for (Rank rank : Rank.values()) {
            int count = getCount(rank);
            total += count * rank.getPrice().getMoney();
        }
        return total;
    }

    public Integer getCount(Rank rank) {
        return this.rankCounts.get(rank);
    }

    private Map<Rank, Integer> getRankCounts() {
        return this.rankCounts;
    }
}
