package lotto.domain;

import java.util.List;

public class Roulette {
    public int compareNumbers(List<Integer> lotto, List<Integer> winningNumber) {
        int count = 0;
        for (int number = 0; number < 6; number++) {
            if (winningNumber.contains(lotto.get(number))) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBonusNumber(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }
}
