package lotto.domain.lotto;

import java.util.List;
import java.util.NoSuchElementException;
import lotto.common.InputErrors;
import lotto.domain.winningresult.WinningType;

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

    public WinningType match(Lotto lotto) {
        int matchedCount = calculateMatchedCount(lotto);
        boolean isBonusMatched = isBonusNumberMatched(lotto);

        try {
            return WinningType.of(matchedCount, isBonusMatched);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(InputErrors.BONUS_NUMBER_DUPLICATED_WIN_NUMBER.getMessage());
        }
    }

    private int calculateMatchedCount(Lotto lotto) {
        int matchedCount = 0;
        for (Integer winNumber : winNumbers) {
            if (lotto.contains(winNumber)) {
                matchedCount++;
            }
        }
        return matchedCount;
    }

    private boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

}
