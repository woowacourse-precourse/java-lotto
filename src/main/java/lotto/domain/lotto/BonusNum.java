package lotto.domain.lotto;

import static lotto.validation.LottoNumberValidation.validateNumberRange;

public class BonusNum {
    private final int num;

    public BonusNum(int num) {
        validate(num);
        this.num = num;
    }

    public static BonusNum makeBonusNum(int num) {
        return new BonusNum(num);
    }

    void validate(int num) {
        validateNumberRange(num);
    }

    public boolean isEqual(int otherNum) {
        return otherNum == num;
    }
}
