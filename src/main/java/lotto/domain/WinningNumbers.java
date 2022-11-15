package lotto.domain;

public class WinningNumbers {

    private static final String ERR_WINNING_CONTAIN_BONUS = "[ERROR] 보너스 번호와 당첨번호는 중복되지 않아야합니다.";

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumbers(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningContainsBonus(Lotto winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERR_WINNING_CONTAIN_BONUS);
        }
    }

}
