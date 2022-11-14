package lotto.machine;

import static lotto.Constants.DUPLICATE_NUMBERS;
import static lotto.Constants.END_NUMBER_INCLUSIVE;
import static lotto.Constants.ERROR_TITLE;
import static lotto.Constants.OUT_OF_RANGE;
import static lotto.Constants.START_NUMBER_INCLUSIVE;

import java.util.List;
import lotto.util.Convertor;

public class Winner {
    private final Integer bonusNumber;
    private final Lotto winningNumbers;

    public Winner(String winningNumbers, String bonusNumber) {
        this.winningNumbers = new Lotto(Convertor.separate(winningNumbers));
        this.bonusNumber = Convertor.toNumericValue(bonusNumber);

        validateBonusNumber(this.winningNumbers.getNumbers(), this.bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateRange(bonusNumber);
        validateIfWinningNumbersContainBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateRange(Integer number) {
        if (number < START_NUMBER_INCLUSIVE || number > END_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_TITLE + OUT_OF_RANGE);
        }
    }

    private void validateIfWinningNumbersContainBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_TITLE + DUPLICATE_NUMBERS);
        }
    }
}
