package lotto.domain;

public class WinningNumbers {

    private static final String ERR_WINNING_CONTAIN_BONUS = "[ERROR] 보너스 번호와 당첨번호는 중복되지 않아야합니다.";

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumbers(Lotto winningNumber, int bonusNumber) {
        validationBonus(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public void validationBonus(Lotto winningNumber, int bonusNumber) {
        winningNumber.validateNumberInRange(bonusNumber);
        validateWinningContainsBonus(winningNumber);
    }

    private void validateWinningContainsBonus(Lotto winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERR_WINNING_CONTAIN_BONUS);
        }
    }

}
