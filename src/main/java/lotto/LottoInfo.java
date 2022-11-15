package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoInfo {
    private static final List<String> prize = Arrays.asList("FIRST", "THIRD", "FOURTH", "FIFTH");
    private final Lotto winNumbers;
    private final int bonusNumber;

    public LottoInfo(Lotto winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.NOT_UNIQUE_NUMBERS.getMessage());
        }
    }

    public boolean isBonusNumberEqual(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public PrizeCode compare(Lotto lotto) {
        int result = winNumbers.compareNumbers(lotto);

        if (result < 3) {
            return PrizeCode.NONE;
        }
        if (result == 5 && isBonusNumberEqual(lotto)) {
            return PrizeCode.SECOND;
        }
        return PrizeCode.valueOf(prize.get(6 - result));
    }
}
