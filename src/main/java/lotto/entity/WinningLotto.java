package lotto.entity;

import static lotto.entity.LottoConstant.RANGE_END;
import static lotto.entity.LottoConstant.RANGE_START;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (outOfRange(bonus)) {
            throw new IllegalArgumentException(
                "보너스 번호는 " + RANGE_START.getValue() + "부터 " + RANGE_END.getValue()
                    + " 사이의 숫자여야 합니다. 입력 : " + bonus);
        }
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복된 숫자를 가지면 안됩니다. 입력 : " + bonus);
        }
    }

    private boolean outOfRange(int bonus) {
        return RANGE_START.getValue() > bonus || RANGE_END.getValue() < bonus;
    }

}
