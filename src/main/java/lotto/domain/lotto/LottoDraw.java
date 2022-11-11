package lotto.domain.lotto;

import java.util.List;
import lotto.common.InputErrors;

public class LottoDraw {
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    private LottoDraw(List<Integer> winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoDraw of(List<Integer> winNumbers, int bonusNumber) {
        return new LottoDraw(winNumbers, bonusNumber);
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputErrors.BONUS_NUMBER_DUPLICATED_WIN_NUMBER.getMessage());
        }
    }

}
