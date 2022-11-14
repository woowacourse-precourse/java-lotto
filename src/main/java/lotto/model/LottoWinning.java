package lotto.model;

import static lotto.config.Constants.LottoNumber.LOTTO_NUMBER_END_INCLUSIVE;
import static lotto.config.Constants.LottoNumber.LOTTO_NUMBER_START_INCLUSIVE;

public class LottoWinning {
    private Lotto winLotto;
    private int winBonus;

    public static class Builder {
        private Lotto winLotto;
        private int winBonus;

        public Builder winLotto(Lotto winLotto) {
            this.winLotto = winLotto;
            return this;
        }

        public Builder winBonus(int winBonus) {
            this.winBonus = winBonus;
            return this;
        }

        public LottoWinning build() {
            return new LottoWinning(this);
        }
    }

    protected LottoWinning() {
    }

    public LottoWinning(Builder builder) {
        this.winLotto = builder.winLotto;
        validateNumberRange(builder.winBonus);
        validateDuplicated(builder.winBonus);
        this.winBonus = builder.winBonus;
    }

    private void validateDuplicated(int bonus) {
        if (winLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(int bonus) {
        if (bonus < LOTTO_NUMBER_START_INCLUSIVE || bonus > LOTTO_NUMBER_END_INCLUSIVE) {
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
