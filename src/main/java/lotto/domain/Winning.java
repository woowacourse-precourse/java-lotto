package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.List;

public class Winning {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Winning(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Winning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private void isNotNumeric(String inputNumbers) {
        if (!inputNumbers.replace(",", "").chars().allMatch(Character::isDigit)) {
            throw new ErrorException(Error.IS_NOT_NUMERIC.toString());
        }
    }
}
