package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private static final int LOTTO_SIZE = 6;

    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningNumbers() {}

    public void newWinningNumbers() {
        List<Integer> inputs = Input.readListInteger(",");
        validateSize(inputs);
        validatedLottoRange(inputs);
        validateDuplicate(inputs);
        winningNumbers = new Lotto(inputs);
    }

    public void newBonusNumber() {
        int input = Input.readInteger();
        validateNumberRange(input);
        bonusNumber = input;
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
