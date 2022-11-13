package lotto.model;

import lotto.util.constants.LottoConstants;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        validate(bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (!isSameRangeAsLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(LottoConstants.ERROR_IS_NOT_SAME_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isSameRangeAsLottoNumber(int bonusNumber) {
        return LottoConstants.LOTTO_NUMBER_MIN <= bonusNumber && bonusNumber <= LottoConstants.LOTTO_NUMBER_MAX;
    }

}
