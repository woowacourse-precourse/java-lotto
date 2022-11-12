package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private static final int LOTTO_SIZE = 6;

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers() {}

    public void newWinningNumbers(List<Integer> newWinningNumbers) {
        validateSize(newWinningNumbers);
        validatedLottoRange(newWinningNumbers);
        validateDuplicate(newWinningNumbers);
        winningNumbers = new Lotto(newWinningNumbers);
    }

    public void newBonusNumber(int newBonusNumber) {
        validateNumberRange(newBonusNumber);
        bonusNumber = newBonusNumber;
    }

    private void validateSize(List<Integer> inputs) {
        if(inputs.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_SIZE.getValue());
        }
    }

    private void validatedLottoRange(List<Integer> inputs) {
        for (Integer input : inputs) {
            validateNumberRange(input);
        }
    }

    private void validateNumberRange(int number) {
        if ((number < 1) || (number > 45)) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_RANGE.getValue());
        }
    }

    private void validateDuplicate(List<Integer> inputs) {
        HashSet<Integer> checkDuplicate = new HashSet<>(inputs);
        if (checkDuplicate.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_DUPLICATE.getValue());
        }
    }
}
