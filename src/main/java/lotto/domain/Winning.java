package lotto.domain;

import java.util.List;

public class Winning {
    Lotto lotto;
    WinningLotto wLotto;
    WinningTable winningTable;

    public Winning(Lotto lotto, WinningLotto wLotto) {
        this.lotto = lotto;
        this.wLotto = wLotto;
    }

    public WinningTable calMyScore() {
        int correctedCount = compareNumbers();
        boolean containsBonus = containsBonus();


       return WinningTable.getRank(correctedCount, containsBonus);
    }

    private int compareNumbers() {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = wLotto.getNumbers();
        numbers.retainAll(winningNumbers);
        return numbers.size();
    }

    private boolean containsBonus() {
        int bonusNumber = wLotto.getBonusNumber();
        return lotto.getNumbers().contains(bonusNumber);
    }
}
