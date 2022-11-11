package lotto.domain;

import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class Result {

    private HashMap<Integer, Integer> rank = new HashMap<>();

    public Result() {
        for (int i = 1; i <= 5; i++) {
            rank.put(i, 0);
        }
    }

    public void initRank(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean isContainBonusNumber = isContainBonusNumber(bonusNumber, lotto);

            combineRank(matchCount, isContainBonusNumber);
        }
    }

    public HashMap<Integer, Integer> getRank() {
        return rank;
    }

    private boolean isContainBonusNumber(int bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void combineRank(int matchCount, boolean isContainBonusNumber) {
        if (matchCount == 6) {
            rank.put(1, rank.get(1) + 1);
            return;
        }
        if (matchCount == 5 && isContainBonusNumber) {
            rank.put(2, rank.get(2) + 1);
            return;
        }
        if (matchCount == 5) {
            rank.put(3, rank.get(3) + 1);
            return;
        }
        if (matchCount == 4) {
            rank.put(4, rank.get(4) + 1);
            return;
        }
        if (matchCount == 3) {
            rank.put(5, rank.get(5) + 1);
        }
    }
}
