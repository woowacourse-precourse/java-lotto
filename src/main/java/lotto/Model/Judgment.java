package lotto.Model;

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

    public boolean hasBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }
}
