package lotto.domain;

import java.util.List;

public class Calculator {

    private void calculate(WinningNumbers winningNumbers, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            calculateCount(winningNumbers, lotto);
        }
    }

    public static int calculateCount(WinningNumbers winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer number : winningNumbers.getWinningNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                count += 1;
            }
        }
        return count;
    }

}
