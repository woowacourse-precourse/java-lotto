package lotto.domain;

import java.util.List;

public class Judgment {
    public static int getCorrectLottoNumberCount(Lotto lotto, List<Integer> winningLotto) {
        int count = 0;
        for (int number : lotto.getLotto()) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
