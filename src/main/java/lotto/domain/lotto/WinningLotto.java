package lotto.domain.lotto;

import lotto.global.message.ErrorMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        validate(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto create(Lotto lotto, BonusBall bonusBall) {
        return new WinningLotto(lotto, bonusBall);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }

    private void validate(Lotto lotto, BonusBall bonusBall) {
        if (lotto.getNumbers().contains(bonusBall.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }
    }
}
