package lotto.domain;

import lotto.constant.IntConstant;
import lotto.constant.StringConstant;
import lotto.validation.IntegerValidation;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        isBonusNumberBetween(bonusNumber, IntConstant.LOTTO_NUMBER_BIGGER_THAN.getValue(),
                IntConstant.LOTTO_NUMBER_SMALLER_THAN.getValue());
        isBonusNumberOverlappingWithWinningLotto(bonusNumber, winningLotto);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void isBonusNumberBetween(int bonusNumber, int valueBiggerThan, int valueSmallerThan) {
        if (!IntegerValidation.isBetween(bonusNumber, valueBiggerThan, valueSmallerThan)) {
            throw new IllegalArgumentException(
                    StringConstant.BONUS_LOTTO_INPUT_NUMBER_BETWEEN_ERROR_MESSAGE.getMessage());
        }
    }

    private void isBonusNumberOverlappingWithWinningLotto(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    StringConstant.BONUS_LOTTO_OVERLAPPING_WITH_WINNING_LOTTO_ERROR_MESSAGE.getMessage());
        }
    }


    public int countLotto(int lottoNum) {
        if (winningLotto.contains(lottoNum)) {
            return 1;
        }
        return 0;
    }

    public int countBonusLotto(int lottoNum) {
        if (bonusNumber == lottoNum) {
            return 1;
        }
        return 0;
    }

}
