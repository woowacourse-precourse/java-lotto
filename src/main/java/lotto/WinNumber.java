package lotto;

public class WinNumber {
    final Lotto winningNumbers;
    final int bonusNumber;

    public WinNumber(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        if (bonusNumber < UniqueFile.MIN || bonusNumber > UniqueFile.MAX) {
            throw new IllegalArgumentException(ErrorMessage.isOutOfBounds(UniqueFile.BONUS));
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.isRepeated(UniqueFile.LOTTO));
        }
    }
}
