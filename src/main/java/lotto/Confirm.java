package lotto;

import java.util.List;

public class Confirm {

    public static int numberCount(List<Integer> winningNumbers, Lotto lotto) {
        int matchNumberCount = 0;

        for (int i = 0; i < winningNumbers.size(); i++) {
            if (winningNumbers.contains(lotto.getNumbers().get(i))) {
                matchNumberCount++;
            }
        }

        return matchNumberCount;
    }

    public static boolean isMatchBonusNumber(int bonusNumber, Lotto lotto) {
        boolean isSecond = false;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                isSecond = true;
            }
        }
        return isSecond;
    }
}
