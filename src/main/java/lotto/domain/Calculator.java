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
        int count = 0;
        for (Integer number : winningNumbers.getWinningNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count += 1;
            }
        }
        if (count == 5 && hasBonus(winningNumbers, lotto)) {
            return Rank.SECOND;
        }
        return rankMapper(count);
    }

    public static Rank rankMapper(int count) {
        if (count == 6) {
            return Rank.FIRST;
        } else if (count == 3) {
            return Rank.FIFTH;
        } else if (count == 4) {
            return Rank.FOURTH;
        } else if (count == 5) {
            return Rank.THIRD;
        }
        return Rank.NOTHING;
    }

    public static boolean hasBonus(WinningNumbers winningNumbers, Lotto lotto) {
        return lotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }

}
