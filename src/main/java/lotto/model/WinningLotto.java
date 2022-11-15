package lotto.model;

import lotto.resource.ErrorType;
import lotto.resource.WinningType;
import lotto.view.Error;

import static lotto.model.Lotto.*;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int countNumberOfMatching(Lotto userLotto) {
        int count = winningLotto.countNumberOfMatching(userLotto);

        if (count == WinningType.FIVE_AND_BONUS.getNumberOfMatching())
            count++;

        if (hasNumberInBonus(userLotto))
            count++;

        return count;
    }

    public boolean hasNumberInBonus(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber))
            Error.printException(ErrorType.DUPLICATE);

        if (bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM)
            Error.printException(ErrorType.RANGE);
    }
}
