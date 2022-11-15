package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> result = new HashMap<>();

    public Result(WinningLotto winningLotto, List<Lotto> lottos, int money) {
        for (Lotto lotto : lottos) {
            computeRank(winningLotto, lotto);
        }
    }

    private void computeRank(WinningLotto winningLotto, Lotto lotto) {
        int count = countMatch(winningLotto.getWinningLotto(), lotto);
        boolean bonus = isBonus(winningLotto.getBonusNumber(), lotto);

        for (Rank rank : Rank.values()) {
            if (rank.common() == count && rank.bonus() && bonus) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
                break;
            }
            if (rank.common() == count) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
                break;
            }
        }
    }

    private int countMatch(Lotto winningLotto, Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(integer -> winningLotto.getNumbers().contains(integer))
                .count();
    }

    private boolean isBonus(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
