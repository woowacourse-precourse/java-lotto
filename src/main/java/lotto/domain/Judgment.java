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

    public static boolean checkBonusCorrect(int bonusNumber, List<Integer> lotto) {
        return lotto.contains(bonusNumber);
    }
}
