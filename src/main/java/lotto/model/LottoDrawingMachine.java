package lotto.model;

import java.util.List;

import static lotto.constant.LottoConstant.*;

public class LottoDrawingMachine {

    private Lotto winningLotto;
    private Integer bonusNumber;

    public void draw(List<Integer> winningNumbers, Integer bonusNumber) {
        winningLotto = new Lotto(winningNumbers);
        validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_RANGE_MIN || bonusNumber > LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER_DUPLICATION);
        }
    }

    protected Lotto getWinningLotto() {
        return winningLotto;
    }

    protected Integer getBonusNumber() {
        return bonusNumber;
    }
}
