package lotto;

import java.util.List;
import java.util.Optional;

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

    private Optional<Winning> checkPrize(List<Integer> lotto, List<Integer> winnigNumber, int bonusNumber) {
        int checkWinning = checkDuplicatedNumber(lotto, winnigNumber, bonusNumber);

        if (checkWinning == 3) {
            return Optional.of(Winning.FIFTH);
        }
        if (checkWinning == 4) {
            return Winning.FOURTH;
        }
        if (checkWinning == 5) {
            return Winning.THIRD;
        }
        if (checkWinning == 6 && lotto.contains(bonusNumber)) {
            return Winning.SECOND;
        }
        if (checkWinning == 6 && !lotto.contains(bonusNumber)) {
            return Winning.FIRST;
        }

        Optional<Winning> optionalWinning = !!!!!;
        if (optionalWinning.isPresent()) {
            Winning winning = optionalWinning.get();
        }

        return Optional.empty();
    }
}
