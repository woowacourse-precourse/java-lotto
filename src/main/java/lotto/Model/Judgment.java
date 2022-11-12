package lotto.Model;

import lotto.Bonus;
import lotto.Lotto;

import java.util.List;

public class Judgment {
    public int compare(Lotto winningLotto, Lotto myLotto) {
        int match = 0;
        List<Integer> winningNumber = winningLotto.getNumbers();
        for (int number : myLotto.getNumbers()) {
            if (winningNumber.contains(number)) {
                match++;
            }
        }

        return match;
    }

    public boolean hasBonusNumber(Lotto myLotto, Bonus bonus) {
        List<Integer> winningNumber = myLotto.getNumbers();
        return winningNumber.contains(bonus.getBonus());
    }
}
