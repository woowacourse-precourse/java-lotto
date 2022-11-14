package lotto.model;

import static lotto.model.Lotto.*;

public class BonusNumber {
    private int bonusNumber;
    private WinningNumber winningNumber;

    public BonusNumber(String bonusNumberString, WinningNumber winningNumber) {
        this.bonusNumber = validate(bonusNumberString, winningNumber);
        this.winningNumber = winningNumber;
    }

    public int validate(String bonusNumberString, WinningNumber winningNumber) {
        int bonusNumber = 0;
        bonusNumber = Integer.parseInt(bonusNumberString);
        if (!(bonusNumber >= LOTTO_NUMBER_MIN && bonusNumber <= LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException();
        }
        if (winningNumber.getWinningNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
