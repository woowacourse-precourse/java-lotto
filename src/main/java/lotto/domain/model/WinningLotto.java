package lotto.domain.model;

import java.util.List;
import lotto.exception.LottoGameExceptionHandler;

public class WinningLotto {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbersumbers, int bonusNumber) {
        validate(winningNumbersumbers, bonusNumber);
        this.winningNumbers = winningNumbersumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        LottoGameExceptionHandler.handleLottoAndWinningException(numbers);
        LottoGameExceptionHandler.handleNumberOutOfRangeException(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
