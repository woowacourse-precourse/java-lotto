package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.isRanged;
import static lotto.messages.ErrorMessage.OUT_OF_RANGE_MESSAGE;

public class BonusNum {
    private final int num;

    public BonusNum(int num) {
        validate(num);
        this.num = num;
    }

    void validate(int num) {
        if (!isRanged(num)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE.toString());
        }
    }

    public boolean isEqual(int otherNum) {
        return otherNum == num;
    }
}
