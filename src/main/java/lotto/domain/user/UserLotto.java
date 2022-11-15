package lotto.domain.user;

import lotto.common.Constant;
import lotto.domain.lotto.Lotto;
import lotto.exception.InputException;

import java.util.List;

public final class UserLotto {

    private final Lotto winNumbers;

    private final int bonusNumber;

    public UserLotto(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = new Lotto(List.copyOf(winNumbers));
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int  bonusNum) {
        isValidBonusLottoRange(bonusNum);
        isBonusNotDuplicateWithWinNumbers(bonusNum);
    }

    private void isValidBonusLottoRange(int bonusNumber) {
        if (Constant.MIN_LOTTO_RANGE > bonusNumber || bonusNumber > Constant.MAX_LOTTO_RANGE) {
            throw new IllegalArgumentException(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }
    }

    private void isBonusNotDuplicateWithWinNumbers(int bonusNumber) {
        if (winNumbers.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(InputException.BONUS_DUPLICATE.message());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLotto() {
        return winNumbers.getNumbers();
    }
}