package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private static final int LOTTO_SIZE = 6;

    private Lotto winningNumbers;
    private int bonusNumber;

    public void pickWinningNumbers() {
        List<Integer> inputs = Input.readListInteger(",");
        validateSize(inputs);
        validateRange(inputs);
        validateDuplicate(inputs);
        winningNumbers = new Lotto(inputs);
    }

    private void validateSize(List<Integer> inputs) {
        if(inputs.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_SIZE.getValue());
        }
    }

    private void validateRange(List<Integer> inputs) {
        for (Integer input : inputs) {
            if ((input < 1) || (input > 45)) {
                throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_RANGE.getValue());
            }
        }
    }

    private void validateDuplicate(List<Integer> inputs) {
        HashSet<Integer> checkDuplicate = new HashSet<>(inputs);
        if (checkDuplicate.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_DUPLICATE.getValue());
        }
    }
}
