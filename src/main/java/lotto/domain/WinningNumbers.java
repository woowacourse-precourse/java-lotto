package lotto.domain;

import static lotto.constants.ErrorConstant.ERR_WINNING_CONTAIN_BONUS;

public class WinningNumbers {

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumbers(Lotto winningNumber, int bonusNumber) {
        validationBonus(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validationBonus(Lotto winningNumber, int bonusNumber) throws IllegalArgumentException{
        winningNumber.validateNumberInRange(bonusNumber);
        validateWinningContainsBonus(winningNumber, bonusNumber);
    }

    private void validateWinningContainsBonus(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERR_WINNING_CONTAIN_BONUS);
        }
    }

    public int countMatchWinningNumber(Lotto lottoTicket) {
        return winningNumber.countMatchNumber(lottoTicket);
    }

    public boolean isMatchBonusNumber(Lotto lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }

}
