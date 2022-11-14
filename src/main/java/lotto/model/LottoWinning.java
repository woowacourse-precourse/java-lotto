package lotto.model;

import static lotto.config.Constants.LottoNumber.LOTTO_NUMBER_END_INCLUSIVE;
import static lotto.config.Constants.LottoNumber.LOTTO_NUMBER_START_INCLUSIVE;

public class LottoWinning {
    private final Lotto winLotto;
    private final int winBonus;

    public LottoWinning(Lotto lotto, int bonus) {
        this.winLotto = lotto;
        validateNumberRange(bonus);
        validateDuplicated(bonus);
        this.winBonus = bonus;
    }

    private void validateDuplicated(int bonus) {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(int bonus) {
        if (bonus >= LOTTO_NUMBER_START_INCLUSIVE && bonus <= LOTTO_NUMBER_END_INCLUSIVE) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getWinBonus() {
        return winBonus;
    }
}
