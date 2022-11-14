package lotto;

public class WinningNumbers {
    final Lotto winningNumbers;
    final int bonusNumber;

    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        if (bonusNumber < Constants.MIN || bonusNumber > Constants.MAX) {
            throw new IllegalArgumentException(ErrorMessages.isOutOfBounds(Constants.BONUS));
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.isRepeated(Constants.LOTTO));
        }
    }
}
