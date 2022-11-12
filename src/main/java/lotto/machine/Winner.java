package lotto.machine;

import java.util.List;
import lotto.ui.Input;
import lotto.util.Convertor;
import lotto.util.Validator;

public class Winner {
    private final Integer bonusNumber;
    private final Lotto winningNumbers;

    public Winner(String winningNumbers, String bonusNumber) {
        this.winningNumbers = new Lotto(Convertor.separate(winningNumbers));
        this.bonusNumber = Convertor.toNumericValue(bonusNumber);
        Validator.checkIfWinningNumbersContainBonusNumber(
                this.winningNumbers.getLottoNumbers(),
                this.bonusNumber
        );
        Validator.checkRange(this.bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getLottoNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
