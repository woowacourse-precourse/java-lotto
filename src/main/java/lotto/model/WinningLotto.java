package lotto.model;

import static lotto.model.Lotto.*;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countWinningNumber(Lotto userLotto) {
        int count = winningLotto.countNumberOfMatching(userLotto);

        if (count == WinningType.FIVE_AND_BONUS.getNumberOfMatching()
                && !hasNumberInBonus(userLotto))
            count++;

        return count;
    }

    public boolean hasNumberInBonus(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            Error.printException(ErrorType.DUPLICATE);
            throw new IllegalArgumentException();
        }

        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM) {
            Error.printException(ErrorType.RANGE);
            throw new IllegalArgumentException();
        }
    }
}
