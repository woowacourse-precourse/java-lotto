package lotto.domain;

import lotto.validation.Validation;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
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
