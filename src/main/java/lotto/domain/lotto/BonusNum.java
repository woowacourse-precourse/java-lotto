package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.isRanged;

public class BonusNum {
    private final int num;

    public BonusNum(int num) {
        validate(num);
        this.num = num;
    }

    void validate(int num) {
        if (!isRanged(num)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 범위가 1 ~ 45 이내가 아닙니다.");
        }
    }

    public boolean isEqual(int otherNum) {
        return otherNum == num;
    }
}
