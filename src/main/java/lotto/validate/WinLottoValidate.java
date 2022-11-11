package lotto.validate;

import lotto.domain.Lotto;

public class WinLottoValidate {
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;

    public void validate(Lotto winLotto, int bonus) {
        bonusRangeValidate(bonus);
        lottoBonusDuplicateValidate(winLotto, bonus);
    }

    private void lottoBonusDuplicateValidate(Lotto winLotto, int bonus) {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    public void bonusRangeValidate(int bonus) {
        if (bonus < START_NUMBER || bonus > LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
