package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Map<Rank, Integer> rankCounts = new HashMap<>();

    public Calculator(WinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
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
        int count = getWinningNumberCounts(winningNumbers, lotto);
        if (count == 5 && hasBonus(winningNumbers, lotto)) {
            return Rank.SECOND;
        }
        return getRankByMatch(count);
    }

    private static int getWinningNumberCounts(WinningNumbers winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer number : winningNumbers.getWinningNumbers()) {
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

    public static boolean hasBonus(WinningNumbers winningNumbers, Lotto lotto) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

    public int getTotalPrice() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            int count = getCount(rank);
            total += count * rank.getPrice().getMoney();
        }
        return total;
    }

    public Integer getCount(Rank rank) {
        return this.rankCounts.get(rank);
    }

}
