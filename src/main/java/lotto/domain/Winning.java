package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    public WinningTable calMyScore(Lotto lotto, WinningLotto winningLotto) {
        int correctedCount = compareNumbers(lotto, winningLotto);
        boolean containsBonus = containsBonus(lotto, winningLotto);

        return WinningTable.getRank(correctedCount, containsBonus);
    }

    private int compareNumbers(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        List<Integer> winningNumbers = winningLotto.getNumbers();
        numbers.retainAll(winningNumbers);
        return numbers.size();
    }

    private boolean containsBonus(Lotto lotto, WinningLotto winningLotto) {
        int bonusNumber = winningLotto.getBonusNumber();
        return lotto.getNumbers().contains(bonusNumber);
    }
}
