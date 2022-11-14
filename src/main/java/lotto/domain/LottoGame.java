package lotto.domain;

import lotto.validation.Validation;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoGame(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        Validation.validateLengthOfList(winningNumbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateListNumberInRange(winningNumbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
    }

    public void validateBonusNumber(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        Validation.validateDuplicatedNumberInList(winningNumbers, bonusNumber);
    }
}
