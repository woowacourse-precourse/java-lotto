package lotto.domain;

public class WinningResult {
    private static final int RANGE_BEGIN = 1;
    private static final int RANGE_END = 45;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningResult(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        validateRange(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다.");
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < RANGE_BEGIN || bonusNumber > RANGE_END) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위 밖의 숫자가 포함되어 있습니다.");
        }
    }
}
