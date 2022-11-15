package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningInfo {
    private static final List<String> PRIZE = Arrays.asList("FIRST", "THIRD", "FOURTH", "FIFTH", "NONE", "NONE", "NONE");
    private final Lotto winNumbers;
    private final int bonusNumber;

    public WinningInfo(Lotto winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.NOT_UNIQUE_NUMBERS.getMessage());
        }
    }

    public PrizeCode compare(Lotto lotto) {
        int result = winNumbers.compareNumbers(lotto);

        if (result == 5 && lotto.contains(bonusNumber)) {
            return PrizeCode.SECOND;
        }
        return PrizeCode.valueOf(PRIZE.get(6 - result));
    }
}
