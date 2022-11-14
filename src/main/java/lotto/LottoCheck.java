package lotto;

import messages.ErrorMessages;
import java.util.HashSet;
import java.util.Set;

public class LottoCheck {
    private final Lotto winningLotto;
    private final Set<Integer> luckyNumbers;
    private final int bonusNumber;

    public LottoCheck(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.luckyNumbers = new HashSet<>(winningLotto.getNumbers());
        validateBonusNumber();
    }

    public LottoRank getRank(Lotto selectedNumber) {
        int sameNumbers = getSameNumbers(selectedNumber);
        if (sameNumbers == 6) return LottoRank.FIRST;
        if (sameNumbers == 5) {
            if (haveBonusNumber(selectedNumber)) return LottoRank.SECOND;
            return LottoRank.THIRD;
        }
        if (sameNumbers == 4) return LottoRank.FOURTH;
        if (sameNumbers == 3) return LottoRank.FIFTH;
        return LottoRank.LOSE;
    }

    private void validateBonusNumber() throws IllegalArgumentException {
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER_RANGE);
        }

        if (luckyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATED);
        }
    }

    private int getSameNumbers(Lotto selectedNumber) {
        int result = 0;
        for (int num : selectedNumber.getNumbers()) {
            if (luckyNumbers.contains(num)) {
                result++;
            }
        }
        return result;
    }

    private boolean haveBonusNumber(Lotto selectedNumber) {
        for (int num : selectedNumber.getNumbers()) {
            if (num == this.bonusNumber) {
                return true;
            }
        }
        return false;
    }
}