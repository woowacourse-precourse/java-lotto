package lotto.domain;

import java.util.List;

public class Calculator {

    public Calculator(WinningNumbers winningNumbers, List<Lotto> lottos) {
        calculate(winningNumbers, lottos);
    }

    private void calculate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(winningNumbers, lotto);
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
