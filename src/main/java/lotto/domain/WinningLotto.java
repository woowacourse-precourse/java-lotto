package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        validateBonusDuplication(winningNumber,bonusNumber);
        validateBonusNumberScope(bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateBonusDuplication(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Lotto.DUPLICATION_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumberScope(int bonusNumber) {
        if (!(bonusNumber >= Lotto.MIN_VALUE && bonusNumber <= Lotto.MAX_VALUE)) {
            throw new IllegalArgumentException(Lotto.SCOPE_ERROR_MESSAGE);
        }
    }

    public boolean containsBonusNumber(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public int countMatchingWinningNumbers(Lotto lotto) {
        int count = 0;
        Set<Integer> numberSet = new HashSet<>(lotto.getNumbers());
        for (Integer number : winningNumber.getNumbers()) {
            if (numberSet.contains(number)) {
                count++;
            }
        }
        return count;
    }
    public int countMatchingNumbers(Lotto lotto) {
        int count = countMatchingWinningNumbers(lotto);
        if (containsBonusNumber(lotto)) {
            count++;
        }
        return count;
    }

    public Ranking calculateRanking(Lotto lotto) {
        return Ranking.getRanking(countMatchingWinningNumbers(lotto),containsBonusNumber(lotto));
    }

}
