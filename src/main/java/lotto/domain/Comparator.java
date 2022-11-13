package lotto.domain;

import java.util.List;

public class Comparator {
    WinningLotto winningLotto;

    public Comparator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int countMatchNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int countMatchNumbers = 0;

        for (int number : numbers) {
            if (winningLotto.getLotto().getNumbers().contains(number)) {
                countMatchNumbers++;
            }
        }
        return countMatchNumbers;
    }

    public boolean checkBonusNumber(Lotto lotto) {
        if (lotto.getNumbers().contains(winningLotto.getBonusNumber())) {
            return true;
        }
        return false;
    }
}
