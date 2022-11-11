package lotto.domain;

import static lotto.constant.SystemMessage.BONUS_NUMBER_CONFLICT_ERROR;

import java.util.List;
import lotto.view.Output;

public class BonusNumber {

    private int bonusNumber;
    private WinningLotto winningLotto;

    public BonusNumber(String bonusNumber, WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        if (!isConflictWithWinningsValid(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return bonusNumber;
    }

    public boolean isConflictWithWinningsValid(String bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        boolean isConflictWithWinnings = winningNumbers.stream()
                .noneMatch(number -> Integer.parseInt(bonusNumber) == number);
        if (!isConflictWithWinnings) {
            Output.printError(BONUS_NUMBER_CONFLICT_ERROR);
        }
        return isConflictWithWinnings;
    }
}
