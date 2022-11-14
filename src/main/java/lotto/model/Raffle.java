package lotto.model;

import lotto.util.Lang;

public class Raffle {
    private final Lotto lotto;
    private Bonus bonus;

    public Raffle(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Raffle(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonus(Bonus bonus) {
        this.validateBonusNotNull();
        this.bonus = bonus;
    }

    public PrizeType getPrizeTypeWith(Lotto ticket) {
        return PrizeType.FIFTH_PRIZE;
    }

    private void validateBonusNotNull() {
        if (bonus != null) {
            throw new RuntimeException(Lang.VARIABLE_NOT_DECLARE);
        }
    }

    private void validateBonusNull() {
        if (bonus == null) {
            throw new RuntimeException(Lang.VARIABLE_DECLARE);
        }
    }
}
