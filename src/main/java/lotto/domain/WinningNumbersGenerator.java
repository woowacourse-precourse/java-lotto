package lotto.domain;

import java.util.List;
import lotto.validate.ValidateBonusNumber;
import lotto.validate.ValidateWinningNumbers;
import lotto.view.Input;

public class WinningNumbersGenerator {
    private WinningNumbers winningNumbers;

    public WinningNumbers generate() {
        winningNumbers = new WinningNumbers(generateWinningNumbers(),
                generateBonusNumbers());
        return winningNumbers;
    }

    private int generateBonusNumbers() throws IllegalArgumentException {
        return ValidateBonusNumber.validate(Input.readBonusNumber());
    }

    private List<Integer> generateWinningNumbers() throws IllegalArgumentException {
        return ValidateWinningNumbers.validate(Input.readWinningNumbers());
    }
}
