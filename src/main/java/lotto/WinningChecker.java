package lotto;

import java.util.List;

public class WinningChecker {

    public WinningChecker() {

    }

    private int checkDuplicatedNumber(List<Integer> lotto, List<Integer> winnigNumber, int bonusNumber) {
        int count = 0;
        for (int winnerNum : winnigNumber) {
            if (lotto.contains(winnerNum)) {
                count++;
            }
        }
        if (lotto.contains(bonusNumber)) {
            count++;
        }

        return count;
    }
}
