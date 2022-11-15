package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class WinningChecker {

    private final HashMap<String, Integer> winnigCount = new HashMap<>();


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

    private HashMap<String, Integer> checkWinningPaperCount(List<Integer> lotto, List<Integer> winnigNumber, int bonusNumber) {
        int checkWinning = checkDuplicatedNumber(lotto, winnigNumber, bonusNumber);

        if (checkWinning == 3) {
            winnigCount.put("5등", winnigCount.getOrDefault("FIFTH", 0) + 1);
        }
        if (checkWinning == 4) {
            winnigCount.put("4등", winnigCount.getOrDefault("FOURTH", 0) + 1);
        }
        if (checkWinning == 5) {
            winnigCount.put("3등", winnigCount.getOrDefault("THIRD", 0) + 1);
        }
        if (checkWinning == 6 && lotto.contains(bonusNumber)) {
            winnigCount.put("2등", winnigCount.getOrDefault("SECOND", 0) + 1);
        }
        if (checkWinning == 6 && !lotto.contains(bonusNumber)) {
            winnigCount.put("1등", winnigCount.getOrDefault("FIRST", 0) + 1);
        }

        return winnigCount;
    }

}
