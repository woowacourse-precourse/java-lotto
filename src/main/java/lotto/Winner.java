package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Lotto;

import static lotto.Constants.*;

public class Winner {
    private final Integer bonusNumber;
    private final Lotto winningNumbers;

    public Winner(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        Validator.checkIfWinningNumbersContainBonusNumber(
                winningNumbers,
                bonusNumber
        );
        Validator.checkRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getLottoNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
