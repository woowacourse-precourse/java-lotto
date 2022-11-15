package lotto.verifier;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.system.ExceptionMessage;

public class RuntimeVerifier {
    public void checkBonusNumberExistsInWinningLotto(BonusNumber bonusNumber, WinningLotto winningLotto) {
        if (winningLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_EXISTS_IN_WINNING_LOTTO);
        }
    }
}
