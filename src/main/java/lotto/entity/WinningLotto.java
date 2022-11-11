package lotto.entity;

import static lotto.service.LottoService.RANGE_END;
import static lotto.service.LottoService.RANGE_START;

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
                "보너스 번호는 " + RANGE_START + "부터 " + RANGE_END + " 사이의 숫자여야 합니다. 입력 : " + bonus);
        }
    }

    private boolean outOfRange(int bonus) {
        return RANGE_START > bonus || RANGE_END < bonus;
    }

}
