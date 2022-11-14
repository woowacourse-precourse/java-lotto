package lotto.model;

import java.util.List;

import static lotto.model.Lotto.*;

public class BonusNumber {
    private int bonusNumber;
    private List<Integer> winningNumber;

    public BonusNumber(String bonusNumberString, List<Integer> winningNumber) {
        this.bonusNumber = validate(bonusNumberString, winningNumber);
        this.winningNumber = winningNumber;
    }

    public int validate(String bonusNumberString, List<Integer> winningNumber) {
        int bonusNumber = 0;
        bonusNumber = Integer.parseInt(bonusNumberString);
        if (!(bonusNumber >= LOTTO_NUMBER_MIN && bonusNumber <= LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException();
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningNumber() {

        return winningNumber;
    }
}
