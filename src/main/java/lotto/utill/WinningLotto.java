package lotto.utill;

import lotto.Messages.Message;

public class WinningLotto {
    private Lotto lotto;
    private int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validateBonus(bonus);
        this.bonus = bonus;
    }

    private void validateBonus(int bonus) {
        if(bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException(Message.BonusNotInRange);
        }
        if((lotto.getNumbers()).contains(bonus)) {
            throw new IllegalArgumentException(Message.BonusSameLotto);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
